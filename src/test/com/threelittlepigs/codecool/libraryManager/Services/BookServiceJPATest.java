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

    @Test
    public void testChangeTitle() {
        BookServiceJPA bookS = new BookServiceJPA();
        String title = bookS.getBookById(1).getTitle();
        bookS.getBookById(1).setTitle("newTitle");
        assertEquals("newTitle", bookS.getBookById(1).getTitle());
    }

}
