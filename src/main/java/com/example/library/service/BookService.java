package com.example.library.service;

import com.example.library.Repository.BookRepo;
import com.example.library.Repository.CategoryRepo;
import com.example.library.model.dto.BookDto;
import com.example.library.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo bookRepo;
    private final CategoryRepo categoryRepo;

    public BookService(BookRepo bookRepo, CategoryRepo categoryRepo) {
        this.bookRepo = bookRepo;
        this.categoryRepo = categoryRepo;
    }

    public Book add(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.getCategories().add(categoryRepo.findById(1L).orElse(null));
        return bookRepo.save(book);
    }

    public Book update(Long id, BookDto bookDto) {
        Book book = bookRepo.findById(id).orElse(null);
        if (book != null) {
            book.setName(bookDto.getName());
            book.getCategories().clear();
            book.getCategories().add(categoryRepo.getById(bookDto.getCategoryId()));
            return bookRepo.save(book);
        }
        return null;

    }

    public Page<Book> show(Pageable pageable) {
        Page<Book> books = bookRepo.findAll(pageable);
        return books;
    }
}
