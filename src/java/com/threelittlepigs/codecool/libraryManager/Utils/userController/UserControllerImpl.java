package com.threelittlepigs.codecool.libraryManager.Utils.userController;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Entities.Fine;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Services.UserService;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserControllerImpl implements UserController{

    @Override
    public ModelAndView renderUserInfo(Request req, Response res, String html) {
        // test id to session
        req.session().attribute("user_id", "1");
        UserService us = new UserService();
        String id = req.session().attribute("user_id");
        User user = us.getUserById(id);
        List<Book> rentedBooks = EntityUtility.getEntityManager().createNamedQuery("getRentedBooksByMember", Book.class).setParameter("rentedByMember", user).getResultList();
        List<Book> reservedBooks = EntityUtility.getEntityManager().createNamedQuery("getReservedBooksByMember", Book.class).setParameter("reservedByMember", user).getResultList();
        List<Fine> fines = EntityUtility.getEntityManager().createNamedQuery("getFineByMember", Fine.class).setParameter("memberid", user.getId()).getResultList();

        Map params = new HashMap<>();
        params.put("user", user);
        params.put("rentedBooks", rentedBooks);
        params.put("reservedBooks", reservedBooks);
        params.put("fines", fines);
        return new ModelAndView(params, html);
    }
}
