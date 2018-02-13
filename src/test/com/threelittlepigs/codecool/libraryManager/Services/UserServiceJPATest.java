package com.threelittlepigs.codecool.libraryManager.Services;

import com.threelittlepigs.codecool.libraryManager.Services.Implementations.UserServiceJPA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceJPATest {

    @Test
    void getUserById() {
        UserServiceJPA us = new UserServiceJPA();
        assertNotNull(us.getUserById(1));
    }

    @Test
    void changeEmailAddress() {
        UserServiceJPA us = new UserServiceJPA();
        String prev_email = us.getUserById(1).getEmail();
        us.changeEmailAddress(prev_email + " changed", 1);
        assertNotEquals(prev_email, us.getUserById(1).getEmail());
    }
}