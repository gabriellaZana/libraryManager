package com.threelittlepigs.codecool.libraryManager.Entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Librarian")
public class Librarian extends User {

    Librarian(String userName, String password, String firstName, String lastName, String email, Date dateOfBirth, String address, String phoneNumber, UserType userType){
        super(userName,password,firstName,lastName, email, dateOfBirth, address, phoneNumber, userType);
    }

    void addBook(Book book){

    }

    void removeBook(Book book){

    }

    void rentBook(Book book, Member member){

    }

    void returnBook(Book book){

    }

    void payFine(Fine fine){

    }
}
