package com.dunkcoder.s3h3p6spy.service;

import java.util.List;

import com.dunkcoder.s3h3p6spy.entity.User;

public interface UserService {
    public void addUser(User user);

    public List<User> getUsers();

    public void deleteUser(long userId);
}