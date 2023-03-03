package pl.galus.bookexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Start {

    private BookRepo bookRepo;

    @Autowired
    public Start(BookRepo bookRepo){
        this.bookRepo = bookRepo;
        bookRepo.save(new Book("Ksiazka Spring Boot3","56583945637"));
        bookRepo.save(new Book("aplikacje internetowe","4532957464"));
        bookRepo.save(new Book("Java dla zaawansowanych","8745362739"));
    }
}
