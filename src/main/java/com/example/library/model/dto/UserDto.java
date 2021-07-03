package com.example.library.model.dto;

import com.example.library.model.entity.Book;

public class UserDto {
    private String name;
    private String codeMeli;
    private int role;
    private Book book;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeMeli() {
        return codeMeli;
    }

    public void setCodeMeli(String codeMeli) {
        this.codeMeli = codeMeli;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
