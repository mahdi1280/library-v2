package com.example.library;

import com.example.library.Repository.ReservRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class LibraryApplicationTests {

    @Autowired
    ReservRepo reservRepo;
    @Test
    void contextLoads() {
        System.out.println(reservRepo.findById(1l).get().getReferenceBook());
    }

}
