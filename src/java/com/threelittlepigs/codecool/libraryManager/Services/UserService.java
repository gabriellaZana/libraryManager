package com.threelittlepigs.codecool.libraryManager.Services;

import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;

import java.util.Map;

public interface UserService {
    void registrateMember(Map<String, String> regData);
    void loginUser();
    User getUserById(int id);
    void getUserByName();
    void changeEmailAddress(String email, int id);
    void changeAddress();
    void changePassword();
    void changePhoneNumber();
    void changeUsername();
}
