package com.example.library.service;

import com.example.library.Repository.BookRepo;
import com.example.library.Repository.ReservRepo;
import com.example.library.Repository.UserRepo;
import com.example.library.model.dto.ReservDto;
import com.example.library.model.entity.Book;
import com.example.library.model.entity.Reserv;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ReservService {

    private final ReservRepo reservRepo;
    private final BookRepo bookRepo;
    private final UserRepo userRepo;
    private int bookCount;

    public ReservService(ReservRepo reservRepo, BookRepo bookRepo, UserRepo userRepo) {
        this.reservRepo = reservRepo;
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    public Reserv add(ReservDto reservDto) {
        Reserv reserv = new Reserv();
        Book book = bookRepo.findById(reservDto.getBook()).orElse(null);
        reserv.setUser(userRepo.findById(reservDto.getUser()).orElse(null));
        reserv.setBook(book);
        reserv.setReservDate(reservDto.getReservDate());
        reserv.setReferenceBook(reservDto.getReferenceBook());

        if (book.getCount() >= 1) {
            bookCount = Objects.requireNonNull(book).getCount() - 1;
            book.setCount(bookCount);
            bookRepo.save(book);
            return reservRepo.save(reserv);
        } else {
            book.setStatus(false);
        }
        return null;
    }

    public Reserv show() {

        Reserv reservs = reservRepo.findById(1L).get();
        return reservs;
    }

    public Reserv returnBook(ReservDto reservDto, Long id) {
        Reserv reserv = reservRepo.findById(id).orElse(null);
//      reserv.setBook(bookRepo.findById(id).orElse(null));
        Book book = bookRepo.findById(reserv.getBook().getId()).orElse(null);
        int bookReturnCount = Objects.requireNonNull(book).getCount();
//        bookCount = Objects.requireNonNull(bookRepo.findById(id).orElse(null)).getCount();
        book.setCount(book.getCount() + 1);
        book.setStatus(true);

        bookRepo.save(book);
        reserv.setReservStatus(false);

        return reservRepo.save(reserv);
    }

}
