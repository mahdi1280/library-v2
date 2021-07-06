package com.example.library.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Reserv {
    private Long id;
    private User user;
    private Book book;
    private boolean reservStatus=true;
    @Column(columnDefinition="boolean default true")
    public boolean isReservStatus() {
        return reservStatus;
    }

    public void setReservStatus(boolean reservStatus) {
        this.reservStatus = reservStatus;
    }

    private LocalDate reservDate;
    private LocalDate referenceBook;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Column(name = "reserv_book")
    public LocalDate getReservDate() {
        return reservDate;
    }

    public void setReservDate(LocalDate reservDate) {
        this.reservDate = reservDate;
    }

    @Column(name = "refrence_book")
    public LocalDate getReferenceBook() {
        return referenceBook;
    }

    public void setReferenceBook(LocalDate referenceBook) {
        this.referenceBook = referenceBook;
    }
}
