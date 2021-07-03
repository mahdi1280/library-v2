package com.example.library.controller;

import com.example.library.model.dto.BookDto;
import com.example.library.model.entity.Book;
import com.example.library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public Book add(@RequestBody BookDto bookDto) {
        return bookService.add(bookDto);
    }

    @PostMapping("/update/{id}")
    public Book update(@RequestBody BookDto bookDto, @PathVariable Long id) {

        return bookService.update(id, bookDto);
    }
    @GetMapping("/show")
    public Page<Book> show(Pageable pageable){
        return bookService.show(pageable);

    }
}
