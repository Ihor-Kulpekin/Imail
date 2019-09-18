package com.kulpekin.imail.service.interfaces;

import com.kulpekin.imail.models.User;

public interface UserServiceInterface {

    void saveUser(User user);

    boolean isUserAlreadyPresent(User user);

    User findUserByEmail(String email);

}
