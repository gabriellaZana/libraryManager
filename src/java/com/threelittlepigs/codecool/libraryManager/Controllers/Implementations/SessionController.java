package com.threelittlepigs.codecool.libraryManager.Controllers.Implementations;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.Member;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Services.BookService;
import com.threelittlepigs.codecool.libraryManager.Services.UserService;
import com.threelittlepigs.codecool.libraryManager.Utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("session")
public class SessionController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

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

    @RequestMapping(value = "/books/{title}", method = RequestMethod.GET)
    public String renderBook(@PathVariable("title") String title, Model model) {
        List<Book> books = bookService.getBooksByTitle(title);
        model.addAttribute("books", books);
        model.addAttribute("user_id", currentUser != null ? currentUser.getId() : 0 );
        model.addAttribute("userName", currentUser != null ? currentUser.getUserName() : "");
        return "book";
    }

    @RequestMapping(value = "/reserve/{isbn}", method = RequestMethod.GET)
    public String reserveBook(@PathVariable("isbn") String isbn, Model model){
        Book book = bookService.getBookByIsbn(isbn);
        book.setReservedBy((Member)currentUser);
        book.setAvailability(false);
        bookService.saveBook(book);
        return "redirect:/books/" + book.getTitle();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Map<String, String> logData, Model model, HttpServletResponse response) {
        if (userService.loginUser(logData) != null) {
            currentUser = userService.loginUser(logData);
            response.setStatus(HttpServletResponse.SC_OK);
            return jsonUtil.toJson(userService.generateUserData(currentUser));
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return "failure";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public String registration(@RequestBody Map<String, Object> regData, Model model) {
        /*if (userService.registrateMember(user) != null) {
            currentUser = userService.registrateMember(user);
            return "success";
        }
        return "failure";*/
        return null;
    }
}
