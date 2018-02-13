package com.threelittlepigs.codecool.libraryManager.Services;

import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;

import java.util.List;

public class UserService {
    void registrateUser(){}
    void loginUser(){}
    public User getUserById(String id){
        List<User> user = EntityUtility.findByOneCriteria(User.class, "id", id);
        System.out.println(user);
        return user.get(0);
    }
    void getUserByName(){}
    void changeEmailAddress(){}
    void changeAddress(){}
    void changePassword(){}
    void changePhoneNumber(){}
    void changeUsername(){}
}
