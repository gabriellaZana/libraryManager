package com.threelittlepigs.codecool.libraryManager.Services;

import com.threelittlepigs.codecool.libraryManager.Services.Implementations.BookServiceJPA;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BookServiceJPATest {

    @Test
    public void testGetBookById() {
        BookServiceJPA bookS = new BookServiceJPA();
        assertNotNull(bookS.getBookById(1));
    }

}
