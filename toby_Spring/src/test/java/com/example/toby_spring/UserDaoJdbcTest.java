package com.example.toby_spring;

import com.example.toby_spring.dao.UserDao;
import com.example.toby_spring.dao.UserDaoJdbc;
import com.example.toby_spring.domain.Level;
import com.example.toby_spring.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserDaoJdbcTest {

    @Autowired
    private UserDao dao;
    @Autowired
    private UserDao dao2;

    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp() {
        user1 = new User("ohmin", "오민규", "springno1", Level.BASIC, 1, 0);
        user2 = new User("gymee", "박성철", "springno2", Level.SILVER, 55, 10);
        user3 = new User("bumjin", "박범진", "springno3", Level.GOLD, 100, 40);
    }

    @Test
    void singleton() {
        System.out.println(dao == dao2);
    }

    @Test
    void addAndSet() throws SQLException {

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        User userGet1 = dao.get(user1.getId());
        checkUser(user1, userGet1);

        User userGet2 = dao.get(user2.getId());
        checkUser(user2, userGet2);
    }

    private void checkUser(User user, User user2) {
        assertEquals(user.getId(), user2.getId());
        assertEquals(user.getPassword(), user2.getPassword());
        assertEquals(user.getLevel(), user2.getLevel());
        assertEquals(user.getLogin(), user2.getLogin());
        assertEquals(user.getRecommend(), user2.getRecommend());
    }

    @Test
    void count() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user1);
        assertThat(dao.getCount()).isEqualTo(1);

        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        dao.add(user3);
        assertThat(dao.getCount()).isEqualTo(3);
    }

    @Test
    void getUserFailure() throws SQLException {
        dao.deleteAll();

        assertThat(dao.getCount()).isEqualTo(0);

        //assertJ
        assertThatThrownBy(() -> {
            dao.get("unknown_id");
        }).isInstanceOf(EmptyResultDataAccessException.class);

        //Junit 5
        assertThrows(EmptyResultDataAccessException.class, () -> dao.get("unknown_id"));
    }

    @Test
    public void update() throws SQLException {
        dao.deleteAll();

        dao.add(user1);

        user1.setName("오민규");
        user1.setPassword("springno6");
        user1.setLevel(Level.GOLD);
        user1.setLogin(1000);
        user1.setRecommend(999);
        dao.update(user1);

        User user1update = dao.get(user1.getId());
        checkUser(user1, user1update);
    }
}