package com.threelittlepigs.codecool.libraryManager.Utils.userController;

import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Services.UserService;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class ThymeleafUserController implements UserController{

    @Override
    public ModelAndView renderUserInfo(Request req, Response res, String html) {
        req.session().attribute("user_id", "1");
        UserService us = new UserService();
        String id = req.session().attribute("user_id");
        User user = us.getUserById(id);

        Map<String, User> params = new HashMap<>();
        params.put("user", user);
        return new ModelAndView(params, html);
    }
}
