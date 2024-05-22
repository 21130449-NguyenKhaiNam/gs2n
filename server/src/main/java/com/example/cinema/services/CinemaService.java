package com.example.cinema.services;

import com.example.cinema.model.Cinema;
import com.example.cinema.model.Movie;
import com.example.cinema.model.ScheduleCinema;
import com.example.cinema.model.ScheduleMovie;
import com.example.cinema.repository.CinemaRepository;
import com.example.cinema.repository.ScheduleCinemaRepository;
import com.example.cinema.repository.ScheduleMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CinemaService extends BaseApi {
    @Autowired
    private CinemaRepository cr;
    @Autowired
    private ScheduleMovieRepository scheduleMovieRepository;
    @Autowired
    private ScheduleCinemaRepository scheduleCinemaRepository;

    @Override
    public List<Object> findAll() {
        return Collections.singletonList(cr.findAll());
    }

    @Override
    public Object save(Object obj) {
        cr.save((Cinema) obj);
        return obj;
    }

    @Override
    public Object delete(int id) {
        Cinema cinema = cr.findById(id).orElseThrow(null);
        if (cinema != null) {
            cr.deleteById(id);
        }
        return null;
    }

    public List<ScheduleCinema> findInfoScheduleCinema(Cinema cinema) {
        return scheduleCinemaRepository.findByCinema(cinema);
    }

    public List<ScheduleMovie> findInfoScheduleMovie(Cinema cinema, Movie movie) {
        List<ScheduleMovie> scheduleMovie = scheduleMovieRepository.findAll();
        List<ScheduleMovie> result = new ArrayList<>();

        for (ScheduleMovie s : scheduleMovie) {
            if (s.getMovie().getId() == movie.getId()) {
                result.add(s);
            }
        }

        return result;
    }

    public Cinema findInfoCinema(int id) {
        return cr.findById(id).orElseThrow(null);
    }
}
