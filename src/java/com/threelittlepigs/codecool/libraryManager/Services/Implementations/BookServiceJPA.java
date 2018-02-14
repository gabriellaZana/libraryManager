package com.threelittlepigs.codecool.libraryManager.Services.Implementations;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Services.BookService;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;

import java.util.List;


public class BookServiceJPA implements BookService {
    public Book getBookById(int id) {
        List<Book> books = EntityUtility.findByOneCriteria(Book.class, "id", String.valueOf(id));
        return books.get(0);
    }

    public Book getBookByTitle(String title) {
        List<Book> books = EntityUtility.findByOneCriteria(Book.class, "title", title);
        return books.get(0);
    }

    public void changeTitle(String title, int id) {
        Book book = getBookById(id);
        book.setTitle(title);
        EntityUtility.mergeEntity(book);
    }

    public void changeAuthor(String author, int id) {
        Book book = getBookById(id);
        book.setAuthor(author);
        EntityUtility.mergeEntity(book);
    }

    public void changePicture() {

    }

    public void changeYear(int year, int id) {
        Book book = getBookById(id);
        book.setYear(year);
        EntityUtility.mergeEntity(book);
    }

    public void changeDescription() {

    }

    public void changePublisher() {

    }

    public void changeGenre() {

    }

    public void changeLocation() {

    }

    public void changeIsbnNum() {

    }

    public void changeAvailability() {

    }
}
