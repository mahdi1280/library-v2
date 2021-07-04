package com.example.library.service;

import com.example.library.Repository.BookRepo;
import com.example.library.Repository.ReservRepo;
import com.example.library.Repository.UserRepo;
import com.example.library.model.dto.ReservDto;
import com.example.library.model.entity.Reserv;
import com.example.library.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservService {

    private final ReservRepo reservRepo;
    private final BookRepo bookRepo;
    private final UserRepo userRepo;

    public ReservService(ReservRepo reservRepo, BookRepo bookRepo, UserRepo userRepo) {
        this.reservRepo = reservRepo;
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    public Reserv add(ReservDto reservDto){
        Reserv reserv = new Reserv();
        reserv.setUser(userRepo.findById(reservDto.getUser()).get());
        reserv.setBook(bookRepo.findById(reservDto.getBook()).get());
        reserv.setReservDate(reservDto.getReservDate());
        reserv.setReferenceBook(reservDto.getReferenceBook());
        return reservRepo.save(reserv);

    }

    public Reserv show() {

       Reserv reservs = reservRepo.findById(1L).get();
        return reservs;
    }

}
