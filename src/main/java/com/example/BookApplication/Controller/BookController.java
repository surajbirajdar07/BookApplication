package com.example.BookApplication.Controller;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/v1")
public class BookController {
    private final BookService bookservice;
    @Autowired
    public BookController(BookService bookservice){
        this.bookservice = bookservice;
    }
   @PostMapping("/addBook")
   public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book savedBook = bookservice.addBook(book);
        return ResponseEntity.ok(savedBook);
    }
    @GetMapping("/getBook/{bookName}")
    public ResponseEntity<Book> grtBookName(@PathVariable("bookname") String name){
        final Book bookByName =  bookservice.getBookByName(name);
        return ResponseEntity.ok(bookByName);
    }
}
