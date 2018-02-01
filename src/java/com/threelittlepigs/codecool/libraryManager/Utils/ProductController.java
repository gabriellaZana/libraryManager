package com.threelittlepigs.codecool.libraryManager.Utils;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductController {

    public static ModelAndView renderProducts(Request req, Response res, String html) {

        List<Book> books = EntityUtility.getEntityManager().createNamedQuery("getAllBooks", Book.class).getResultList();

        Map params = new HashMap<>();
        params.put("books", books);
        return new ModelAndView(params, html);
    }

}
