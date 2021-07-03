package com.example.library.service;

import com.example.library.Repository.BookRepo;
import com.example.library.model.dto.BookDto;
import com.example.library.model.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    private Book add(BookDto bookDto){
        Book book = new Book();
        book.setName(bookDto.getName());
        book.getCategories().add(bookDto.getCategory());
        book.getUsers().add(bookDto.getUser());
        return bookRepo.save(book);
    }
//    private Book update(Long id,BookDto bookDto){
//        bookRepo.findById(id);
//
//    }
}
