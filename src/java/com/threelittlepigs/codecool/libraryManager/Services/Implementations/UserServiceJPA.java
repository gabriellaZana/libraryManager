package com.threelittlepigs.codecool.libraryManager.Services.Implementations;

import com.threelittlepigs.codecool.libraryManager.Entities.Users.Member;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Services.UserService;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;
import org.mindrot.jbcrypt.BCrypt;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
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

    public User loginUser(Map<String, String> loginData){
        User user = (User) EntityUtility.findByOneCriteria(User.class, "userName", loginData.get("userName")).get(0);
        if (BCrypt.checkpw(loginData.get("password"), user.getPassword())) {
            return user;
        }
        return null;
    }

    public User getUserById(int id){
        List<User> users = EntityUtility.findByOneCriteria(User.class, "id", String.valueOf(id));
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);   // Error handling needed here, when the users list is empty it throws an error
    }
    public User getUserByName(String firstName, String lastName){
        List<String> columns = Arrays.asList("firstName", "lastName");
        List<String> values = Arrays.asList(firstName, lastName);
        List<User> users = EntityUtility.findByTwoCriteria(User.class, columns, values);
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    public void changeEmailAddress(String email, int id) {
        User currentUser = getUserById(id);
        currentUser.setEmail(email);
        EntityUtility.mergeEntity(currentUser);
    }

    public void changeAddress(String address, int id){
        User currentUser = getUserById(id);
        currentUser.setAddress(address);
        EntityUtility.mergeEntity(currentUser);
    }

    public void changePassword(String pw, int id){
        User currentUser = getUserById(id);
        currentUser.setPassword(BCrypt.hashpw(pw, BCrypt.gensalt()));
        EntityUtility.mergeEntity(currentUser);
    }

    public void changePhoneNumber(String phoneNumber, int id){
        User currentUser = getUserById(id);
        currentUser.setPhoneNumber(phoneNumber);
        EntityUtility.mergeEntity(currentUser);
    }

    public void changeUsername(String userName, int id){
        User currentUser = getUserById(id);
        currentUser.setUserName(userName);
        EntityUtility.mergeEntity(currentUser);
    }

    public void ensureUserIsLoggedIn(Request req, Response res) {
        if (req.session().attribute("username") == null) {
            res.redirect("/login");
        }
    }
}
