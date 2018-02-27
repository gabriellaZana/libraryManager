package com.threelittlepigs.codecool.libraryManager.Controllers.Implementations;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Entities.Fine;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.Member;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Services.BookService;
import com.threelittlepigs.codecool.libraryManager.Services.FineService;
import com.threelittlepigs.codecool.libraryManager.Services.UserService;
import com.threelittlepigs.codecool.libraryManager.Utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"id", "name"})
@Scope("session")
public class SessionController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private FineService fineService;

    @Autowired
    JSONUtil jsonUtil;

    private User currentUser = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("user_id", currentUser != null ? currentUser.getId() : 0 );
        model.addAttribute("userName", currentUser != null ? currentUser.getUserName() : "");
        return "index";
    }

    @RequestMapping(value = "/books/{isbn}", method = RequestMethod.GET)
    public String renderBook(@PathVariable("isbn") String isbn, Model model) {
        List<Book> books = bookService.getBooksByIsbn(isbn);
        model.addAttribute("books", books);
        model.addAttribute("user_id", currentUser.getId());
        model.addAttribute("userName", currentUser.getUserName());
        return "book";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Map<String, String> logData, ModelMap model, HttpServletResponse response) {
        Map<String, String> error = new HashMap<>();
        currentUser = userService.loginUser(logData, error);
        if (succeededToCreateUser(model, response)) return jsonUtil.toJson(userService.generateUserData(currentUser));
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return jsonUtil.toJson(error);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String registration(@RequestBody Map<String, String> regData, ModelMap model, HttpServletResponse response) {
        Map<String, String> error = new HashMap<>();
        currentUser = userService.registrateMember(regData, error);
        if (succeededToCreateUser(model, response)) return jsonUtil.toJson(userService.generateUserData(currentUser));
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return jsonUtil.toJson(error);
    }

    private boolean succeededToCreateUser(ModelMap model, HttpServletResponse response) {
        if (currentUser != null) {
            response.setStatus(HttpServletResponse.SC_OK);
            model.put("userName", currentUser.getUserName());
            model.put("id", currentUser.getId());
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/userprofile/{id}", method = RequestMethod.GET)
    public String renderUserInfo(@PathVariable("id") String id, Model model) {

        List<Book> rentedBooks = bookService.getBookByRentedByMemberId(currentUser);
        List<Book> reservedBooks = bookService.getBookByReservedByMemberId(currentUser);
        List<Fine> fines = fineService.getFinesByMemberId(Long.valueOf(id));

        model.addAttribute("user", currentUser);
        model.addAttribute("rentedBooks", rentedBooks);
        model.addAttribute("reservedBooks", reservedBooks);
        model.addAttribute("fines", fines);
        return "userinfo";
    }
}
