package com.example.cinema.repository;

import com.example.cinema.model.ScheduleMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleMovieRepository extends JpaRepository<ScheduleMovie, Integer> {

}
