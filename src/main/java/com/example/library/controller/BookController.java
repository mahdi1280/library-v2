package com.example.library.controller;

import com.example.library.model.dto.BookDto;
import com.example.library.model.entity.Book;
import com.example.library.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/add")
    public Book add(@RequestBody BookDto bookDto){
        return bookService.add(bookDto);
    }
}
