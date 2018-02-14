package com.threelittlepigs.codecool.libraryManager.Entities.Users;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import com.threelittlepigs.codecool.libraryManager.Entities.Fine;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Librarian")
public class Librarian extends User {

    public Librarian(String userName, String password, String firstName, String lastName, String email, Date dateOfBirth, String address, String phoneNumber){
        super(userName,password,firstName,lastName, email, dateOfBirth, address, phoneNumber);
    }

    public Librarian() {
        super();
    }

    public void addBook(Book book){
        EntityUtility.persistEntity(book);
    }

    public void removeBook(Book book){
        EntityUtility.removeEntity(book);
    }

    public void rentBook(Book book, Member member){
        book.setRentedBy(member);
        book.setAvailability(false);
    }

    public void returnBook(Book book){
        book.setRentedBy(null);
        book.setAvailability(true); // redundant, we could calculate this from setRentedBy Not null value
    }

    public void payFine(Fine fine){
        fine.setStatus(false);
    }
}
