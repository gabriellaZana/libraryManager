package com.threelittlepigs.codecool.libraryManager.Repository;

import com.threelittlepigs.codecool.libraryManager.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This is how you define basic CRUD operations on the Customer entity
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> getBooksByIsbn(String isbn);

}