package com.threelittlepigs.codecool.libraryManager.Services.Implementations;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Enums.Genre;
import com.threelittlepigs.codecool.libraryManager.Enums.Location;
import com.threelittlepigs.codecool.libraryManager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceJPA implements BookService {

    @Autowired
    private UserRepository bookRepository;

    @Override
    public Book getBookById(int id) {
        List<Book> books = EntityUtility.findByOneCriteria(Book.class, "id", String.valueOf(id));
        return books.get(0);
    }

    @Override
    public Book getBookByTitle(String title) {
        List<Book> books = EntityUtility.findByOneCriteria(Book.class, "title", title);
        return books.get(0);
    }

    @Override
    public void changeTitle(String title, int id) {
        Book book = getBookById(id);
        book.setTitle(title);
    }

    @Override
    public void changeAuthor(String author, int id) {
        Book book = getBookById(id);
        book.setAuthor(author);
    }

    @Override
    public void changePicture(String pic_url, int id) {
        Book book = getBookById(id);
        book.setPicture_url(pic_url);
    }

    @Override
    public void changeYear(int year, int id) {
        Book book = getBookById(id);
        book.setYear(year);
    }

    @Override
    public void changeDescription(String desc, int id) {
        Book book = getBookById(id);
        book.setDescription(desc);
    }

    @Override
    public void changePublisher(String publisher, int id) {
        Book book = getBookById(id);
        book.setPublisher(publisher);
    }

    @Override
    public void changeGenre(Genre genre, int id) {
        Book book = getBookById(id);
        book.setGenre(genre);
    }

    @Override
    public void changeLocation(Location location, int id) {
        Book book = getBookById(id);
        book.setLocation(location);
    }

    @Override
    public void changeIsbnNum(String isbn, int id) {
        Book book = getBookById(id);
        book.setIsbn(isbn);
    }

    @Override
    public void changeAvailability(boolean isAvailable, int id) {
        Book book = getBookById(id);
        book.setAvailability(isAvailable);
    }
}
