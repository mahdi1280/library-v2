package com.example.library.Repository;

import com.example.library.model.entity.Reserv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservRepo extends JpaRepository<Reserv, Integer> {
}
