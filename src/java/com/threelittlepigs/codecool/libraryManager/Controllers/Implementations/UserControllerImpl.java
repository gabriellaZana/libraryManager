package com.threelittlepigs.codecool.libraryManager.Controllers.Implementations;

import com.threelittlepigs.codecool.libraryManager.Controllers.UserController;
import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Entities.Fine;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Services.Implementations.UserServiceJPA;
import com.threelittlepigs.codecool.libraryManager.Services.UserService;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;
import com.threelittlepigs.codecool.libraryManager.Utils.JSONUtils;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserControllerImpl implements UserController {

    @Override
    public String login(Request request, Response response) {
        Map<String, String> loginData = JSONUtils.parseJson(request);
        UserService us = new UserServiceJPA();
        if (us.loginUser(loginData)) {
            request.session(true);
            request.session().attribute("userName", loginData.get("logUserName"));
            request.session().attribute("user_id", (int) us.getUserByUsername(loginData.get("logUserName")).getId());
            return "";
        }
        return "failure";
    }

    @Override
    public String logout(Request request, Response response) {
        request.session().removeAttribute("userName");
        request.session().removeAttribute("user_id");
        response.redirect("/");
        return "";
    }

    @Override
    public String registration(Request request, Response response) {
        Map<String, String> regData = JSONUtils.parseJson(request);
        UserService us = new UserServiceJPA();
        if (us.registrateMember(regData)) {
            return "";
        }
        return "failure";
    }

    public boolean ensureUserIsLoggedIn(Request req, Response res) {
        return req.session().attribute("userName") != null;
    }

    @Override
    public ModelAndView renderUserInfo(Request req, Response res, String html) {

        UserService us = new UserServiceJPA();
        Integer id = req.session().attribute("user_id");
        if (id == null) {
            res.redirect("/");
        }
        User user = us.getUserById(id);
        List<Book> rentedBooks = EntityUtility.getEntityManager().createNamedQuery("getRentedBooksByMember", Book.class).setParameter("rentedByMember", user).getResultList();
        List<Book> reservedBooks = EntityUtility.getEntityManager().createNamedQuery("getReservedBooksByMember", Book.class).setParameter("reservedByMember", user).getResultList();
        List<Fine> fines = EntityUtility.getEntityManager().createNamedQuery("getFineByMember", Fine.class).setParameter("memberid", user.getId()).getResultList();

        Map params = new HashMap<>();
        params.put("user", user);
        params.put("rentedBooks", rentedBooks);
        params.put("reservedBooks", reservedBooks);
        params.put("fines", fines);
        params.put("user_id", id);
        params.put("userName", req.session().attribute("userName"));

        return new ModelAndView(params, html);
    }
}
