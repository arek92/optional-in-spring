package pl.galus.bookexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

class BookApiTest {



    @Test
    void shouldFindBookByID() {

        BookApi bookApiMock = Mockito.mock(BookApi.class);
        List<Book>testList = booksToTest();
        Mockito.when(bookApiMock.getBook(1)).thenReturn(testList.get(0));
        Book bookFounded = bookApiMock.getBook(1);
        Assertions.assertEquals(bookFounded.getTitle(),"Ksiazka Spring Boot3");


    }
    private List<Book> booksToTest (){
        List<Book> books = new ArrayList<>();
        books.add(new Book("Ksiazka Spring Boot3","56583945637"));
        books.add(new Book("aplikacje internetowe","4532957464"));
        books.add(new Book("Java dla zaawansowanych","8745362739"));
        return books;
    }

}