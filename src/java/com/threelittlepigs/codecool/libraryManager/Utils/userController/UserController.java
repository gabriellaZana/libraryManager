package com.threelittlepigs.codecool.libraryManager.Utils.userController;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public interface UserController {

    ModelAndView renderUserInfo(Request req, Response res, String html);
    
}
