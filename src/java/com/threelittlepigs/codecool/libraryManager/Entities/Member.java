package com.threelittlepigs.codecool.libraryManager.Entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("Member")
class Member extends User{

    @OneToMany(mappedBy = "rentedByMember")
    List<Book> rentedBooks = new ArrayList<>();

    @OneToMany(mappedBy = "reservedByMember")
    List<Book> reservedBooks = new ArrayList<>();

    Member(String userName, String password, String firstName, String lastName, String email, Date dateOfBirth, String address, String phoneNumber, UserType userType){
        super(userName, password, firstName, lastName, email, dateOfBirth, address, phoneNumber, userType);
    }

    public Member() {
    }

    void reserveBook(Book book){

    }

}
