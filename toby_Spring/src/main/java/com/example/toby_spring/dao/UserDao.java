package com.example.toby_spring.dao;

import com.example.toby_spring.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void add(final User user);

    User get(String id);

    void deleteAll();

    int getCount();

    List<User> getAll();

    void update(User user);
}
