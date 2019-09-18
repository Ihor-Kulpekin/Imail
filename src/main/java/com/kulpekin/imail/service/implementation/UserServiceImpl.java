package com.kulpekin.imail.service.implementation;

import com.kulpekin.imail.dao.interfaces.UserDaoInterface;
import com.kulpekin.imail.models.User;
import com.kulpekin.imail.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface {

    private final UserDaoInterface userDaoInterface;

    @Autowired
    public UserServiceImpl(UserDaoInterface userDaoInterface) {
        this.userDaoInterface = userDaoInterface;
    }

    @Override
    public void saveUser(User user) {
        userDaoInterface.save(user);
    }

    @Override
    public boolean isUserAlreadyPresent(User user) {
        return user != null;
    }

    @Override
    public User findUserByEmail(String email) {
        return userDaoInterface.findByEmail(email);
    }
}
