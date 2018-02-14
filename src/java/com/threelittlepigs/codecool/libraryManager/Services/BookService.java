package com.threelittlepigs.codecool.libraryManager.Services;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;


public interface BookService {
    Book getBookById(int id);
    Book getBookByTitle(String title);
    void changeTitle(String title, int id);
    void changeAuthor(String author, int id);
    void changePicture();
    void changeYear(int year, int id);
    void changeDescription();
    void changePublisher();
    void changeGenre();
    void changeLocation();
    void changeIsbnNum();
    void changeAvailability();
}
