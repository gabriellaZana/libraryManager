package com.threelittlepigs.codecool.libraryManager.Controllers;

import com.threelittlepigs.codecool.libraryManager.Services.Implementations.UserServiceJPA;
import com.threelittlepigs.codecool.libraryManager.Services.UserService;
import com.threelittlepigs.codecool.libraryManager.Utils.JSONUtils;
import spark.Request;
import spark.Response;

import java.util.Map;

public class UserControllerImpl implements UserController{

    @Override
    public String login(Request request, Response response) {
        Map<String, String> loginData = JSONUtils.parseJson(request);
        UserService us = new UserServiceJPA();
        if (us.loginUser(loginData)) {
            request.session(true);
            request.session().attribute("userName", loginData.get("logUserName"));
            System.out.println((String) request.session().attribute("userName"));
            return "";
        }
        return "failure";
    }

    @Override
    public String logout(Request request, Response response) {
        request.session().removeAttribute("userName");
        response.redirect("/");
        return "";
    }

    @Override
    public String registration(Request request, Response response) {
        Map<String, String> regData = JSONUtils.parseJson(request);
        UserService us = new UserServiceJPA();
        if (us.registrateMember(regData)) {
            return "";
        }
        return "failure";
    }

    public boolean ensureUserIsLoggedIn(Request req, Response res) {
        return req.session().attribute("userName") != null;
    }
}
