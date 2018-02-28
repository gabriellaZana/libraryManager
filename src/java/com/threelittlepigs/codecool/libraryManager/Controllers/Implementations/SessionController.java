package com.threelittlepigs.codecool.libraryManager.Controllers.Implementations;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Entities.Fine;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.Librarian;
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

    @RequestMapping(value = "/books/{title}", method = RequestMethod.GET)
    public String renderBook(@PathVariable("title") String title, Model model) {
        List<Book> books = bookService.getBooksByTitle(title);
        model.addAttribute("librarian", currentUser instanceof Librarian);
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
    public String login(@RequestBody Map<String, String> logData, ModelMap model, HttpServletResponse response) {
        Map<String, String> error = new HashMap<>();
        currentUser = userService.loginUser(logData, error);
        if (succeededToCreateUser(model, response)) return jsonUtil.toJson(userService.generateUserData(currentUser));
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return jsonUtil.toJson(error);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout() {
        currentUser = null;
        return "redirect:/";
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
        model.addAttribute("user_id", currentUser != null ? currentUser.getId() : 0 );
        model.addAttribute("userName", currentUser != null ? currentUser.getUserName() : "");
        model.addAttribute("rentedBooks", rentedBooks);
        model.addAttribute("reservedBooks", reservedBooks);
        model.addAttribute("fines", fines);
        return "userinfo";
    }

    @RequestMapping(value = "/editbook", method = RequestMethod.POST)
    public String renderEditBookInfo(@RequestParam  Map<String, String> bookData ,Model model) {

        List<Book> books = bookService.getBooksByTitle(bookData.get("title"));
        model.addAttribute("books", books);
        return "editbook";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String saveBookEdit(@RequestParam  Map<String, String> bookData) {
        String formerTitle = bookData.get("formerTitle");
        String title = bookData.get("title");
        String author = bookData.get("author");
        String description = bookData.get("description");
        List<Book> books = bookService.getBooksByTitle(formerTitle);
        for (Book book : books) {
            String isbn = bookData.get(String.valueOf(book.getId()));
            bookService.updateBookInfo(book, title, author, description, isbn);
        }
        return "redirect:books/" + title;
    }
}
