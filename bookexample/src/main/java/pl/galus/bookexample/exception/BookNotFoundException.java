package pl.galus.bookexample.exception;

public class BookNotFoundException extends RuntimeException {



    public BookNotFoundException(long id){
        super("could not find book" + id);

    }
}
