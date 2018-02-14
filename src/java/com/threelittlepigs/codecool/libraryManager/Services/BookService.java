package com.threelittlepigs.codecool.libraryManager.Services;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;


public interface BookService {
    Book getBookById(int id);
    Book getBookByTitle(String title);
    void changeTitle();
    void changeAuthor();
    void changePicture();
    void changeYear();
    void changeDescription();
    void changePublisher();
    void changeGenre();
    void changeLocation();
    void changeIsbnNum();
    void changeAvailability();
}
