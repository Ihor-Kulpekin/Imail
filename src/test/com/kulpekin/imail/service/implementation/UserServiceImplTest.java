package com.kulpekin.imail.service.implementation;

import com.kulpekin.imail.dao.interfaces.RoleDaoInterface;
import com.kulpekin.imail.models.Role;
import com.kulpekin.imail.models.User;
import com.kulpekin.imail.service.interfaces.UserServiceInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.*;


@Rollback
@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private RoleDaoInterface roleDaoInterface;

    private User expectedUser;

    @Before
    public void setUp() {
        expectedUser = new User();
        expectedUser.setId(1);
        expectedUser.setPassword("12345s");
        expectedUser.setLastName("as");
        expectedUser.setName("cxz");
        expectedUser.setEmail("kulpekin20@gmail.com");
        Role userRole = roleDaoInterface.findByRole("SITE_USER");
        expectedUser.setRoles(new HashSet<>(Collections.singletonList(userRole)));
    }

    @Test
    public void saveUserTest() {
        userService.saveUser(expectedUser);
        User resultUser = userService.findUserByEmail("kulpekin20@gmail.com");
        assertNotNull(resultUser);
    }

    @Test
    public void isUserAlreadyPresentTest() {
        userService.saveUser(expectedUser);
        User resultUser = userService.findUserByEmail("kulpekin20@gmail.com");
        boolean isUserExist = userService.isUserAlreadyPresent(resultUser);
        assertTrue(isUserExist);
    }

    @Test
    public void findUserByEmailTest() {
        userService.saveUser(expectedUser);
        User resultUser = userService.findUserByEmail("kulpekin20@gmail.com");
        assertNotNull(resultUser);
    }
}