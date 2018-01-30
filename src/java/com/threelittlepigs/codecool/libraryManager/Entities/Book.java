package com.threelittlepigs.codecool.libraryManager.Entities;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String author;

    @Column(name = "picture")
    private String picture_url;

    private int year;
    private String description;
    private String publisher;
    private Genre genre;
    private Location location;
    private String isbn;
    private boolean isAvailable = true;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    private int rentedBy;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    private int reservedBy;


    public Book(String title, String author, String picture_url, int year, String description, String publisher,
                Genre genre, Location location, String isbn) {
        this.title = title;
        this.author = author;
        this.picture_url = picture_url;
        this.year = year;
        this.description = description;
        this.publisher = publisher;
        this.genre = genre;
        this.location = location;
        allBooks.add(this);
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(int rentedBy) {
        this.rentedBy = rentedBy;
    }

    public int getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(int reservedBy) {
        this.reservedBy = reservedBy;
    }
}