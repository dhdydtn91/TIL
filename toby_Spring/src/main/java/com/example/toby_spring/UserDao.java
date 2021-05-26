package com.example.toby_spring;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;


public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userMapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        return user;
    };

    public void add(final User user) throws SQLException {
        DuplicateKeyException
        this.jdbcTemplate.update("INSERT INTO USERS (id, name, password) values (?, ? ,?)",
                user.getId(),
                user.getName(),
                user.getPassword());
    }

    public User get(String id) throws SQLException {
        return this.jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE ID = ?",
                new Object[]{id},
                this.userMapper);
    }


    public void deleteAll() throws SQLException {
        this.jdbcTemplate.update("DELETE FROM USERS");
    }

    public int getCount() throws SQLException {
        return this.jdbcTemplate.queryForObject("SELECT count(*) FROM USERS", Integer.class);
    }

    public List<User> getAll() throws SQLException {
        return this.jdbcTemplate.query("SELECT * FROM USERS ORDER BY ID", this.userMapper);
    }
}
