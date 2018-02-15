package com.threelittlepigs.codecool.libraryManager.Controllers;


import spark.ModelAndView;
import spark.Request;
import spark.Response;

public interface UserController {
    String login(Request request, Response response);
    String logout(Request request, Response response);
    String registration(Request request, Response response);
    boolean ensureUserIsLoggedIn(Request request, Response response);
    public ModelAndView renderUserInfo(Request req, Response res, String html);
}
