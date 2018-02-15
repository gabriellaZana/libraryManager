package com.threelittlepigs.codecool.libraryManager.Controllers;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;
import com.threelittlepigs.codecool.libraryManager.Utils.JSONUtils;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookControllerImpl implements BookController {

    @Override

    public ModelAndView renderBooks(Request req, Response res, String html, boolean isLoggedIn) {
        List<Book> books = EntityUtility.getEntityManager().createNamedQuery("getAllBooks", Book.class).getResultList();
        Map<String, List> params = new HashMap<>();
        params.put("books", books);
        params.put("isLoggedIn", Collections.singletonList(isLoggedIn));
        params.put("user_id", req.session().attribute("user_id"));
        params.put("userName", req.session().attribute("userName"));
        return new ModelAndView(params, html);
    }

    @Override
    public ModelAndView renderBook(Request req, Response res, String html, String isbn) {
        List<Book> books = EntityUtility.findByOneCriteria(Book.class,"isbn",isbn);

        Map<String, List> params = new HashMap<>();
        params.put("books", books);
        params.put("user_id", req.session().attribute("user_id"));
        params.put("userName", req.session().attribute("userName"));
        return new ModelAndView(params, html);
    }

}
