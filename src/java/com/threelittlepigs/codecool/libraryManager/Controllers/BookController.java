package com.threelittlepigs.codecool.libraryManager.Controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public interface BookController {

    ModelAndView renderBooks(Request req, Response res, String html, boolean isLoggedIn);

    ModelAndView renderBook(Request req, Response res, String html, String isbn);

}
