package com.threelittlepigs.codecool.libraryManager.Utils;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Services.UserService;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThymleafBookController implements Controller {

    @Override
    public ModelAndView renderBooks(Request req, Response res, String html) {
        req.session().attribute("user_id", "1");

        List<Book> books = EntityUtility.getEntityManager().createNamedQuery("getAllBooks", Book.class).getResultList();

        Map<String, List> params = new HashMap<>();
        params.put("books", books);
        params.put("session", req.session().attribute("user_id"));
        return new ModelAndView(params, html);
    }

    @Override
    public ModelAndView renderBook(Request req, Response res, String html, String isbn) {
        List<Book> books = EntityUtility.findByOneCriteria(Book.class,"isbn",isbn);

        Map<String, List> params = new HashMap<>();
        params.put("books", books);
        return new ModelAndView(params, html);
    }

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
