package com.threelittlepigs.codecool.libraryManager.Services;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Enums.Genre;
import com.threelittlepigs.codecool.libraryManager.Enums.Location;


public interface BookService {
    Book getBookById(int id);
    Book getBookByTitle(String title);
    void changeTitle(String title, int id);
    void changeAuthor(String author, int id);
    void changePicture(String pic_url, int id);
    void changeYear(int year, int id);
    void changeDescription(String desc, int id);
    void changePublisher(String publisher, int id);
    void changeGenre(Genre genre, int id);
    void changeLocation(Location location, int id);
    void changeIsbnNum(String isbn, int id);
    void changeAvailability(boolean isAvailable, int id);
}
