package com.example.toby_spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao dao;
    @Autowired
    private UserDao dao2;

    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        user1 = new User("gymee", "박성철", "springno1");
        user2 = new User("gymee", "박성철", "springno1");

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

        //Junit 5문법
        assertEquals(user1.getId(), userGet1.getId());
        assertEquals(user1.getPassword(), userGet1.getPassword());

        User userGet2 = dao.get(user2.getId());

        //Junit 5문법
        assertEquals(user2.getId(), userGet2.getId());
        assertEquals(user2.getPassword(), userGet2.getPassword());

    }

    @Test
    void count() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user1);
        assertThat(dao.getCount()).isEqualTo(1);

        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

//        dao.add(user3);
//        assertThat(dao.getCount()).isEqualTo(3);
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

}