package com.example.library.model.dto;

import com.example.library.model.entity.Category;
import com.example.library.model.entity.User;

public class BookDto {
    private String name;
    private User user;
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
