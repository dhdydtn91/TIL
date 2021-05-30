package com.example.toby_spring.service;

import com.example.toby_spring.dao.DaoFactory;
import com.example.toby_spring.dao.UserDao;
import com.example.toby_spring.domain.Level;
import com.example.toby_spring.domain.User;
import com.example.toby_spring.util.MockMailSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

import static com.example.toby_spring.service.UserService.NIN_LOGOUT_FOR_SILVER;
import static com.example.toby_spring.service.UserService.NIN_RECCOMEND_FOR_GOLD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = DaoFactory.class)
class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    private List<User> users;
    @Autowired
    private MailSender mailSender;
    @Autowired
    PlatformTransactionManager transactionManager;

    @BeforeEach
    public void setUp() {
        users = List.of(
                new User("bumjin", "박범진", "p1", Level.BASIC, NIN_LOGOUT_FOR_SILVER - 1, 0),
                new User("joytouch", "강명성", "p2", Level.BASIC, NIN_LOGOUT_FOR_SILVER, 0),
                new User("erwins", "신승한", "p3", Level.SILVER, 60, NIN_RECCOMEND_FOR_GOLD - 1),
                new User("madnite1", "이상호", "p4", Level.SILVER, 60, NIN_RECCOMEND_FOR_GOLD),
                new User("green", "오민규", "p5", Level.GOLD, 100, Integer.MAX_VALUE)
        );
    }

    @Test
    public void bean() {
        assertThat(this.userService).isNotNull();
    }

    @Test
    @DirtiesContext
    public void upgradeLevels() throws Exception {
        userDao.deleteAll();
        for (User user : users) {
            userDao.add(user);
        }
        MockMailSender mailSender = new MockMailSender();
        userService.setMailSender(mailSender);
        userService.upgradeLevels();

        checkLevel(users.get(0), false);
        checkLevel(users.get(1), true);
        checkLevel(users.get(2), false);
        checkLevel(users.get(3), true);
        checkLevel(users.get(4), false);

        List<String> request = mailSender.getRequests();
        assertThat(request.size()).isEqualTo(2);
        assertThat(request.get(0)).isEqualTo(users.get(1).getEmail());
        assertThat(request.get(1)).isEqualTo(users.get(3).getEmail());
    }

    private void checkLevel(User user, boolean upgraded) {
        User userUpdate = userDao.get(user.getId());
        if (upgraded) {
            assertThat(userUpdate.getLevel()).isEqualTo(user.getLevel().nextLevel());
        } else {
            assertThat(userUpdate.getLevel()).isEqualTo(user.getLevel());
        }
    }

    @Test
    public void add() {
        userDao.deleteAll();

        User userWithLevel = users.get(4);
        User userWithoutLevel = users.get(0);
        userWithoutLevel.setLevel(null);

        userService.add(userWithLevel);
        userService.add(userWithoutLevel);

        User userWithLevelRead = userDao.get(userWithLevel.getId());
        User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());

        assertThat(userWithLevelRead.getLevel()).isEqualTo(userWithLevel.getLevel());
        assertThat(userWithoutLevelRead.getLevel()).isEqualTo(Level.BASIC);
    }

    @Test
    void upgradeAllOrNothing() throws Exception {
        UserService testUserService = new TestUserService(users.get(3).getId());
        testUserService.setUserDao(this.userDao);
        testUserService.setTransactionManager(transactionManager);
        testUserService.setMailSender(mailSender);
        userDao.deleteAll();
        for (User user : users) {
            userDao.add(user);
        }
        assertThatThrownBy(() -> {
            testUserService.upgradeLevels();
        }).isInstanceOf(TestUserServiceException.class);

        checkLevel(users.get(1), false);
    }

    static class TestUserService extends UserService {

        private String id;

        private TestUserService(String id) {
            this.id = id;
        }

        protected void upgradeLevel(User user) {
            if (user.getId().equals(this.id)) {
                throw new TestUserServiceException();
            }
            super.upgradeLevel(user);
        }

    }

    static class TestUserServiceException extends RuntimeException {
    }
}