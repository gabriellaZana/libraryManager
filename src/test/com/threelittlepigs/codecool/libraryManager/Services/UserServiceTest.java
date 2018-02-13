package com.threelittlepigs.codecool.libraryManager.Services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void getUserById() {
        UserService us = new UserService();
        assertNotNull(us.getUserById("1"));
    }
}