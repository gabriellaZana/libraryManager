package com.threelittlepigs.codecool.libraryManager;

import com.threelittlepigs.codecool.libraryManager.Services.Implementations.UserServiceJPA;
import com.threelittlepigs.codecool.libraryManager.Services.UserService;
import com.threelittlepigs.codecool.libraryManager.Utils.Controller;
import com.threelittlepigs.codecool.libraryManager.Utils.JSONUtils;
import com.threelittlepigs.codecool.libraryManager.Utils.ThymleafBookController;
import spark.Request;
import spark.Response;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class Library {
    public static void main(String[] args) {

        Controller controller = new ThymleafBookController();
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("static");
        port(8888);

        get("/", (Request req, Response res) -> new ThymeleafTemplateEngine().render(controller.renderBooks(req, res, "index")));

        get("/books/:isbn", (Request req, Response res) -> {
            String isbn = req.params(":isbn");
            return new ThymeleafTemplateEngine().render(controller.renderBook(req, res, "book",isbn));
        });

        post("/register", (Request request, Response response) -> {
            Map<String, String> regData = JSONUtils.parseJson(request);
            UserService us = new UserServiceJPA();
            if (us.registrateMember(regData)) {
                return "";
            }
            return "failure";
        });
        enableDebugScreen();
        /*populateDB();
    }

    public static void populateDB() {
        Book book = new Book("Kis malacok", "György Mátyás", "https://moly.hu/system/covers/big/covers_262639.jpg?1395465884", 1997, "Test", "Béla", Genre.Christian, Location.AQUARIUM, "SAD145831");
        Book book1 = new Book("Kis 1", "György Mátyás", "https://www.dramaturg.hu/sites/default/files/default_images/konyv%5B1%5D.png   ", 1997, "Test", "Béla", Genre.Christian, Location.AQUARIUM, "asd");
        Book book2 = new Book("Kis 2", "György Mátyás", "http://www.innoportal.hu/wp-content/uploads/2012/01/book.png", 1997, "Test", "Béla", Genre.Christian, Location.AQUARIUM, "SAD1asdasda45831");
        Book book3 = new Book("Kis 3", "György Mátyás", "http://fvmaszk.hu/wp-content/uploads/konyv.jpg", 1997, "Test", "Béla", Genre.Christian, Location.AQUARIUM, "SAD14asdasdasdasdasd5831");
        Librarian librarian = new Librarian("amigo", "asdasdasd", "Béla", "Kvács", "bk@gmail.cm", new Date(), "Fixaddress", "0908070605");
        Member member = new Member("membergo", "asdasdasd", "Béla", "Membertest", "bl@gmail.com", new Date(), "shit", "0908745161");
        Fine regFee = new Fine(15.0, new Date(), new Date(), member);

        EntityUtility.persistEntity(member);
        EntityUtility.persistEntity(regFee);
        EntityUtility.persistEntity(librarian);
        librarian.addBook(book);
        librarian.addBook(book1);
        librarian.addBook(book2);
        librarian.addBook(book3);
        book.setIsbn("Tested");
        List<Book> books = EntityUtility.getEntityManager().createNamedQuery("getAllBooks", Book.class).getResultList();
        System.out.println(books);

        List books1 = EntityUtility.findByOneCriteria(Book.class, "title", "Kis 1");
        System.out.println(books1);
        EntityUtility.mergeEntity(book);
    }*/
    }
}
