package nl.appall.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BooksController {

    private final BookRepository bookRepository;
    private final PageRepository pageRepository;
    public BooksController(BookRepository bookRepository, PageRepository pageRepository) {
        this.bookRepository = bookRepository;
        this.pageRepository = pageRepository;
    }

    @GetMapping(value = "/pages", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Page> pages(){
        List<Page> result = (List<Page>) pageRepository.findAll();
        System.out.println(result);
        System.out.println(result.get(0));
        return result;
    }
    @GetMapping("/")
    public List<Book> books(){
        return (List<Book>)bookRepository.findAll();
    }
}
