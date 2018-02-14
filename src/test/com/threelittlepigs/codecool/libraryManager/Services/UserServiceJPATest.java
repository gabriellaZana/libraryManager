package com.threelittlepigs.codecool.libraryManager.Services;

import com.threelittlepigs.codecool.libraryManager.Services.Implementations.UserServiceJPA;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceJPATest {

    @Test
    void testGetUserById() {
        UserServiceJPA us = new UserServiceJPA();
        assertNotNull(us.getUserById(1));
    }

    @Test
    void testGetUserByIdWithNull() {
        UserService us = new UserServiceJPA();
        assertNull(us.getUserById(45));
    }

    @Test
    void testChangeEmailAddress() {
        UserServiceJPA us = new UserServiceJPA();
        String prev_email = us.getUserById(1).getEmail();
        us.changeEmailAddress(prev_email + " changed", 1);
        assertNotEquals(prev_email, us.getUserById(1).getEmail());
    }

    @Test
    void testLogin() {
        UserService us = new UserServiceJPA();
        Map<String, String> loginData = new HashMap<>();
        loginData.put("userName", "membergo");
        loginData.put("password", "asdasdasd");
        assertNotNull(us.loginUser(loginData));
    }

    @Test
    void testGetUserByName() {
        UserService us = new UserServiceJPA();
        assertNotNull(us.getUserByName("Bla", "kv"));
    }

    @Test
    void testGetUserByEmail() {
        UserService us = new UserServiceJPA();
        assertEquals(us.getUserByEmailAddress("bk@gmail.cm").getEmail(), "bk@gmail.cm");
    }

    @Test
    void testRegistration() {

    }
}