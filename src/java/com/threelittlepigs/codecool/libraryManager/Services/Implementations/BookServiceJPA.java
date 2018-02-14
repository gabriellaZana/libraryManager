package com.threelittlepigs.codecool.libraryManager.Services.Implementations;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Enums.Genre;
import com.threelittlepigs.codecool.libraryManager.Enums.Location;
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

    public void changePicture(String pic_url, int id) {
        Book book = getBookById(id);
        book.setPicture_url(pic_url);
        EntityUtility.mergeEntity(book);
    }

    public void changeYear(int year, int id) {
        Book book = getBookById(id);
        book.setYear(year);
        EntityUtility.mergeEntity(book);
    }

    public void changeDescription(String desc, int id) {
        Book book = getBookById(id);
        book.setDescription(desc);
        EntityUtility.mergeEntity(book);
    }

    public void changePublisher(String publisher, int id) {
        Book book = getBookById(id);
        book.setPublisher(publisher);
        EntityUtility.mergeEntity(book);
    }

    public void changeGenre(Genre genre, int id) {
        Book book = getBookById(id);
        book.setGenre(genre);
        EntityUtility.mergeEntity(book);
    }

    public void changeLocation(Location location, int id) {
        Book book = getBookById(id);
        book.setLocation(location);
        EntityUtility.mergeEntity(book);
    }

    public void changeIsbnNum(String isbn, int id) {
        Book book = getBookById(id);
        book.setIsbn(isbn);
        EntityUtility.mergeEntity(book);
    }

    public void changeAvailability(boolean isAvailable, int id) {
        Book book = getBookById(id);
        book.setAvailability(isAvailable);
        EntityUtility.mergeEntity(book);
    }
}
