package com.example.cinema.services;

import com.example.cinema.model.Cinema;
import com.example.cinema.model.Movie;
import com.example.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MovieService extends BaseApi{
    @Autowired
    private MovieRepository mr;

    @Override
    public List<Object> findAll() {
        return Collections.singletonList(mr.findAll());
    }

    @Override
    public Object save(Object obj) {
        return mr.save((Movie) obj);
    }

    @Override
    public Object delete(int id) {
        Movie movie = mr.findById(id).orElseThrow(null);
        if (movie != null) {
            mr.deleteById(id);
        }
        return null;
    }
}
