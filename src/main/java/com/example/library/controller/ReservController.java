package com.example.library.controller;

import com.example.library.model.dto.ReservDto;
import com.example.library.model.entity.Reserv;
import com.example.library.service.ReservService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/update/{id}")
    public Reserv update(@PathVariable Long id, ReservDto reservDto) {
        return null;
    }

    @PostMapping("/show")
    public Page<Reserv> show(Pageable pageable) {
        return reservService.show(pageable);
    }
}
