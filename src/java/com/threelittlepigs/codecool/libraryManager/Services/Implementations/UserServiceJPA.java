package com.threelittlepigs.codecool.libraryManager.Services.Implementations;

import com.threelittlepigs.codecool.libraryManager.Entities.Users.Member;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Services.UserService;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserServiceJPA implements UserService {
    public void registrateMember(Map<String, String> regData){
        LocalDate localDate = LocalDate.parse(regData.get("birthDate"));
        Date birthDate = Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
        Member newUser = new Member(regData.get("userName"),regData.get("password"), regData.get("firstName"), regData.get("lastName"), regData.get("email"), birthDate, regData.get("address"), regData.get("phoneNumber"));
        EntityUtility.persistEntity(newUser);
    }
    public void loginUser(){}
    public User getUserById(int id){
        List<User> users = EntityUtility.findByOneCriteria(User.class, "id", String.valueOf(id));
        return users.get(0);   // Error handling needed here, when the users list is empty it throws an error
    }
    public void getUserByName(){}

    public void changeEmailAddress(String email, int id) {
        User currentUser = getUserById(id);
        currentUser.setEmail(email);
        EntityUtility.mergeEntity(currentUser);
    }

    public void changeAddress(){}
    public void changePassword(){}
    public void changePhoneNumber(){}
    public void changeUsername(){}
}
