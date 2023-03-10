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
    public void shouldAddBook(){
        BookApi bookApiMock = Mockito.mock(BookApi.class);
        Book bookToTest = new Book("Jezyk SQL co to ?","873574585");
        Mockito.when(bookApiMock.addBook(Mockito.any(Book.class))).thenReturn(bookToTest);
        Book bookAdded = bookApiMock.addBook(bookToTest);
        Assertions.assertEquals(bookAdded.getTitle(),"Jezyk SQL co to ?");


    }

    @Test
    public void shouldReturnALlBooksFromDataBase(){
        BookApi bookApiMock = Mockito.mock(BookApi.class);
        Mockito.when(bookApiMock.getAllBooks()).thenReturn(booksToTest());
        List<Book> result = bookApiMock.getAllBooks();
        Assertions.assertEquals(booksToTest().size(),result.size());

    }



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