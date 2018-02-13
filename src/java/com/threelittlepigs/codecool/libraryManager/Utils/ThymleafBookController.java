package com.threelittlepigs.codecool.libraryManager.Utils;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThymleafBookController implements Controller {

    @Override
    public ModelAndView renderBooks(Request req, Response res, String html) {

        List<Book> books = EntityUtility.getEntityManager().createNamedQuery("getAllBooks", Book.class).getResultList();

        Map<String, List> params = new HashMap<>();
        params.put("books", books);
        return new ModelAndView(params, html);
    }

    @Override
    public ModelAndView renderBook(Request req, Response res, String html, int id) {
        return null;
    }

}
