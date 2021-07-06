package com.example.library.controller;

import com.example.library.Repository.ReservRepo;
import com.example.library.model.dto.ReservDto;
import com.example.library.model.entity.Book;
import com.example.library.model.entity.Reserv;
import com.example.library.model.entity.User;
import com.example.library.service.ReservService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.security.acl.LastOwnerException;
import java.util.List;

@RestController
@RequestMapping("/reserv")
public class ReservController {

    private final ReservService reservService;

    public ReservController(ReservService reservService) {
        this.reservService = reservService;
    }

    @PostMapping("/add")
    public Reserv add(@RequestBody ReservDto reservDto) {
        return reservService.add(reservDto);
    }

    @PostMapping("/update/{id}")
    public Reserv update(@PathVariable Long id, ReservDto reservDto) {
        return null;
    }

    @PostMapping("/return/{id}")
     public Reserv returnBook(@PathVariable Long id,@RequestBody ReservDto reservDto){
        return reservService.returnBook(reservDto,id);
    }
    @GetMapping("/show")
    public Long show() {
        return 1L;
    }


    @GetMapping("/show1")
    public Reserv show1() {
        return  new Reserv();
    }

}
