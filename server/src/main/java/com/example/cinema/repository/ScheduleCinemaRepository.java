package com.example.cinema.repository;

import com.example.cinema.model.Cinema;
import com.example.cinema.model.ScheduleCinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleCinemaRepository extends JpaRepository<ScheduleCinema, Integer> {
    List<ScheduleCinema> findByCinema(Cinema cinema);
}
