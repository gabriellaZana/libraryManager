package com.threelittlepigs.codecool.libraryManager.Services;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Enums.Genre;
import com.threelittlepigs.codecool.libraryManager.Enums.Location;
import com.threelittlepigs.codecool.libraryManager.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        Book book = bookRepository.findOne(Long.valueOf(id));
        return book;
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getBooksByIsbn(String isbn) {
        /*return bookRepository.getBooksByIsbn(isbn);*/
        return null;
    }

    public Book getBookByTitle(String title) {
        /*List<Book> books = EntityUtility.findByOneCriteria(Book.class, "title", title);
        return books.get(0);*/
        return null;
    }


    public void changeTitle(String title, int id) {
        Book book = getBookById(id);
        book.setTitle(title);
    }

    public void changeAuthor(String author, int id) {
        Book book = getBookById(id);
        book.setAuthor(author);
    }

    public void changePicture(String pic_url, int id) {
        Book book = getBookById(id);
        book.setPicture_url(pic_url);
    }

    public void changeYear(int year, int id) {
        Book book = getBookById(id);
        book.setYear(year);
    }

    public void changeDescription(String desc, int id) {
        Book book = getBookById(id);
        book.setDescription(desc);
    }

    public void changePublisher(String publisher, int id) {
        Book book = getBookById(id);
        book.setPublisher(publisher);
    }

    public void changeGenre(Genre genre, int id) {
        Book book = getBookById(id);
        book.setGenre(genre);
    }

    public void changeLocation(Location location, int id) {
        Book book = getBookById(id);
        book.setLocation(location);
    }

    public void changeIsbnNum(String isbn, int id) {
        Book book = getBookById(id);
        book.setIsbn(isbn);
    }

    public void changeAvailability(boolean isAvailable, int id) {
        Book book = getBookById(id);
        book.setAvailability(isAvailable);
    }

    public List<Book> getBookByRentedByMemberId(User user) {
        return bookRepository.getAllByReservedByMember(user);
    }

    public List<Book> getBookByReservedByMemberId(User user) {
        return bookRepository.getAllByRentedByMember(user);
    }
}
