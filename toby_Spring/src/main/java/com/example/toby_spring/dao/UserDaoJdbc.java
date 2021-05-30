package com.example.toby_spring.dao;

import com.example.toby_spring.domain.Level;
import com.example.toby_spring.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;


public class UserDaoJdbc implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDaoJdbc(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userMapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        user.setLevel(Level.valueOf(rs.getInt("level")));
        user.setLogin(rs.getInt("login"));
        user.setRecommend(rs.getInt("recommend"));
        return user;
    };

    public void add(final User user) {
        this.jdbcTemplate.update("INSERT INTO USERS (id, name, password, level , login, recommend) values (?, ? ,?,?,?,?)",
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getLevel().intValue(),
                user.getLogin(),
                user.getRecommend());
    }

    public User get(String id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE ID = ?",
                new Object[]{id},
                this.userMapper);
    }


    public void deleteAll() {
        this.jdbcTemplate.update("DELETE FROM USERS");
    }

    public int getCount() {
        return this.jdbcTemplate.queryForObject("SELECT count(*) FROM USERS", Integer.class);
    }

    public List<User> getAll() {
        return this.jdbcTemplate.query("SELECT * FROM USERS ORDER BY ID", this.userMapper);
    }

    public void update(User user) {
        this.jdbcTemplate.update(
                "UPDATE USERS SET NAME = ?, PASSWORD = ?, LEVEL = ? , LOGIN = ?, RECOMMEND = ? WHERE ID =?",
                user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getId()
        );
    }
}
