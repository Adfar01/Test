package com.demo.Test.Controller;

import com.demo.Test.Entities.Book;
import com.demo.Test.Repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @PostMapping
     public Book createBookRecord(@RequestBody @Valid Book bookRecord){
        return bookRepository.save(bookRecord);
    }

    @GetMapping
    public List<Book> getAllBookRecords(){
        return bookRepository.findAll();
    }
      @GetMapping(value="/{bookId}")
        public Book getBookById(@PathVariable(value="bookId") String bookId){
            return bookRepository.findById(bookId).get();
        }


     @PutMapping
    public Book updateBookRecord(@RequestBody @Valid Book bookRecord) {

         Book bookExists = bookRepository.findById(bookRecord.getBookId()).orElseThrow(
                 () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with Id:" + bookRecord.getBookId() + " does not exist.")
         );

           bookExists.setName(bookRecord.getName());
           bookExists.setSummary(bookRecord.getSummary());
           bookExists.setRating(bookRecord.getRating());
           return bookRepository.save(bookExists);
     }

     @DeleteMapping("/{bookId}")
    public String deleteBookRecord(@PathVariable Book bookId){
         Book book = bookRepository.findById(String.valueOf(bookId)).orElseThrow(
                 () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with Id:" + bookId + " does not exist.")
         );
         bookRepository.delete(book);
         return "BookRecord Deleted";
     }
}

