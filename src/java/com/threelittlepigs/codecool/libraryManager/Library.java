package com.threelittlepigs.codecool.libraryManager;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Enums.Genre;
import com.threelittlepigs.codecool.libraryManager.Entities.UserType;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.Librarian;
import com.threelittlepigs.codecool.libraryManager.Enums.Location;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;

import java.util.Date;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("Kis malacok", "György Mátyás", "placeholder", 1997, "Test", "Béla", Genre.Christian, Location.AQUARIUM, "SAD145831");
        Librarian librarian = new Librarian("amigo", "asdasdasd", "Béla", "Kvács", "bk@gmail.cm", new Date(), "Fixaddress", "0907495161", UserType.LIBRARIAN);

        EntityUtility.persistEntity(librarian);

        librarian.addBook(book);
    }
}
