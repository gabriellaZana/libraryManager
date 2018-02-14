package com.threelittlepigs.codecool.libraryManager.Services;

import com.threelittlepigs.codecool.libraryManager.Services.Implementations.UserServiceJPA;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceJPATest {

    @Test
    void testGetUserById() {
        UserService us = new UserServiceJPA();
        assertNotNull(us.getUserById(1));
    }

    @Test
    void testGetUserByIdWithNull() {
        UserService us = new UserServiceJPA();
        assertNull(us.getUserById(45));
    }

    @Test
    void testChangeEmailAddress() {
        UserService us = new UserServiceJPA();
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
        assertNotNull(us.getUserByName("Béla", "Kvács"));
    }

    @Test
    void testGetUserByEmail() {
        UserService us = new UserServiceJPA();
        assertEquals(us.getUserByEmailAddress("bk@gmail.cm").getEmail(), "bk@gmail.cm");
    }

    @Test
    void testChangeUsername() {
        UserService us = new UserServiceJPA();
        String prevUsername = us.getUserById(2).getUserName();
        us.changeUsername(prevUsername + " changed", 2);
        assertNotEquals(prevUsername, us.getUserById(2).getUserName());
    }

    @Test
    void testChangeAddress() {
        UserService us = new UserServiceJPA();
        String prevAddress = us.getUserById(2).getAddress();
        us.changeAddress(prevAddress + " changed", 2);
        assertNotEquals(prevAddress, us.getUserById(2).getAddress());
    }

    @Test
    void testChangePassword() {
        UserService us = new UserServiceJPA();
        String prevPassword = us.getUserById(2).getPassword();
        us.changePassword(prevPassword + " changed", 2);
        assertNotEquals(prevPassword, us.getUserById(2).getPassword());
    }

    @Test
    void testChangePhoneNumber() {
        UserService us = new UserServiceJPA();
        String prevPhoneNumber = us.getUserById(2).getPhoneNumber();
        us.changePhoneNumber(prevPhoneNumber + " changed", 2);
        assertNotEquals(prevPhoneNumber, us.getUserById(2).getPhoneNumber());
    }

    @Test
    void testRegistration() {

    }
}