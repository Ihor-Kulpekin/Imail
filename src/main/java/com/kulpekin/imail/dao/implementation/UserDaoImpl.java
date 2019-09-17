package com.kulpekin.imail.dao.implementation;

import com.kulpekin.imail.dao.interfaces.UserDaoInterface;
import com.kulpekin.imail.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDaoInterface {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void registerUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

}
