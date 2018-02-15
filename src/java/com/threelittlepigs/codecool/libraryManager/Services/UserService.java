package com.threelittlepigs.codecool.libraryManager.Services;

import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import spark.Request;
import spark.Response;

import java.util.Map;

public interface UserService {
    boolean registrateMember(Map<String, String> regData);
    User loginUser(Map<String, String> loginData);
    User getUserById(int id);
    User getUserByName(String firstName, String lastName);
    User getUserByEmailAddress(String email);
    void changeEmailAddress(String email, int id);
    void changeAddress(String address, int id);
    void changePassword(String pw, int id);
    void changePhoneNumber(String phoneNumber, int id);
    void changeUsername(String userName, int id);
    User getUserByUsername(String username);
}
