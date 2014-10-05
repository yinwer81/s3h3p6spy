package com.dunkcoder.s3h3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dunkcoder.s3h3.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return this.sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    public void deleteUser(long userId) {
        User employee = (User) sessionFactory.getCurrentSession().load(User.class, userId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
    }
}