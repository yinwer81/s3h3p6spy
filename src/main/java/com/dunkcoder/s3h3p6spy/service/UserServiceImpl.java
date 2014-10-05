package com.dunkcoder.s3h3p6spy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dunkcoder.s3h3p6spy.dao.UserDao;
import com.dunkcoder.s3h3p6spy.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Transactional
    public void deleteUser(long userId) {
        userDao.deleteUser(userId);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
