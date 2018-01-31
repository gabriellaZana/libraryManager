package com.threelittlepigs.codecool.libraryManager;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Enums.Genre;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.Librarian;
import com.threelittlepigs.codecool.libraryManager.Enums.Location;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;
import spark.Request;
import spark.Response;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;
import java.util.Date;

public class Library {
    public static void main(String[] args) {

        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("static");
        port(8888);

        get("/", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(ProductController.renderProducts(req, res, "index"));
        });

        //populateDB();
        enableDebugScreen();
    }
}
