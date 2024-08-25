package ir.freeland.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/basic")
public class BasicOfMappingController {

    public BasicOfMappingController() {
        super();
    }

    // API

 // BOOKS ENDPOINTS

    @GetMapping(value = "/books")
    public String listBooks() {
        return "Listing all books";
    }
    
    @PostMapping(value = "/books")
    public String createBook() {
        return "Book has been created";
    }
    
    @GetMapping(value = "/books/{id}")
    public String getBookById(@PathVariable final long id) {
        return "Fetching details of book with ID: " + id;
    }
    
    @PutMapping(value = "/books/{id}")
    public String updateBookById(@PathVariable final long id) {
        return "Updating book with ID: " + id;
    }
    
    @DeleteMapping(value = "/books/{id}")
    public String removeBookById(@PathVariable final long id) {
        return "Book with ID " + id + " has been deleted";
    }


}