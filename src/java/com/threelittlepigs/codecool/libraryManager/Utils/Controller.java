package com.threelittlepigs.codecool.libraryManager.Utils;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public interface Controller {

    ModelAndView renderBooks(Request req, Response res, String html);

    ModelAndView renderBook(Request req, Response res, String html, String isbn);

}
