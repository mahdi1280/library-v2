package com.example.library.service;

import com.example.library.Repository.ReservRepo;
import com.example.library.model.dto.ReservDto;
import com.example.library.model.entity.Reserv;
import org.springframework.stereotype.Service;

@Service
public class ReservService {

    private final ReservRepo reservRepo;

    public ReservService(ReservRepo reservRepo) {
        this.reservRepo = reservRepo;
    }

    public Reserv add(ReservDto reservDto){
        Reserv reserv = new Reserv();
        return reserv;
    }
}
