package com.example.library.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class User {
    private Long id;
    private String name;
    private String codeMeli;
    private int role;
    private Collection<Book> books = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
}
