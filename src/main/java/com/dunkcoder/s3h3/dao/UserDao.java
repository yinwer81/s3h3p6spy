package com.dunkcoder.s3h3.dao;

import java.util.List;

import com.dunkcoder.s3h3.entity.User;

public interface UserDao {
    public void addUser(User user);

    public List<User> getUsers();

    public void deleteUser(long userId);
}