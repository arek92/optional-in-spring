package pl.galus.bookexample;

import org.springframework.web.bind.annotation.*;
import pl.galus.bookexample.exception.BookNotFoundException;

import java.util.List;

@RestController
public class BookApi {

    private BookRepo bookRepo;

    public BookApi(BookRepo bookRepo){
        this.bookRepo  = bookRepo;
    }
    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable long id){
        return bookRepo.findById(id).orElseThrow(()->new BookNotFoundException(id));
    }
    @PutMapping("book/{id}")
    public Book updateBook(@RequestBody Book newBook,@PathVariable long id){
        return bookRepo.findById(id)
                .map(element-> {
                            element.setTitle(newBook.getTitle());
                            element.setISBN(newBook.getISBN());
                            return bookRepo.save(element);
                        })
                .orElseGet(()->{
                    newBook.setId(id);
                   return bookRepo.save(newBook);
                });
    }
    @GetMapping("/getAllBooks")
    public List<Book>getAllBooks(){
        return bookRepo.findAll();
    }


}
