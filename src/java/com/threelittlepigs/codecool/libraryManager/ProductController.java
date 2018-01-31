package com.threelittlepigs.codecool.libraryManager;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class ProductController {

    public static ModelAndView renderProducts(Request req, Response res, String html) {

        Map params = new HashMap<>();

        return new ModelAndView(params, html);
    }

}
