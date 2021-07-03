package com.example.library.model.dto;

import com.example.library.model.entity.Book;
import com.example.library.model.entity.User;

import java.time.LocalDate;

public class ReservDto {

    private User user;
    private Book book;
    private LocalDate reservDate;
    private LocalDate referenceBook;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getReservDate() {
        return reservDate;
    }

    public void setReservDate(LocalDate reservDate) {
        this.reservDate = reservDate;
    }

    public LocalDate getReferenceBook() {
        return referenceBook;
    }

    public void setReferenceBook(LocalDate referenceBook) {
        this.referenceBook = referenceBook;
    }
}
