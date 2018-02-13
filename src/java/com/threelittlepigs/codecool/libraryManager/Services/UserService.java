package com.threelittlepigs.codecool.libraryManager.Services;

import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;

public interface UserService {
    void registrateUser();
    void loginUser();
    User getUserById(int id);
    void getUserByName();
    void changeEmailAddress(String email, int id);
    void changeAddress();
    void changePassword();
    void changePhoneNumber();
    void changeUsername();
}
