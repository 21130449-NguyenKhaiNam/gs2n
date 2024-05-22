package com.example.cinema.controller;

import com.example.cinema.model.ResponseObject;
import com.example.cinema.model.User;
import com.example.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieManagementApi {
    @Autowired
    private MovieService ms;

    @GetMapping("")
    public ResponseEntity<ResponseObject> findAll() {
        List<Object> findAll = ms.findAll();

        if (!findAll.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Find all successfully", findAll));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "Find all failed", findAll));
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseObject> save(@RequestBody Object obj) {
        User user = (User) ms.save(obj);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Get movie successfully", user));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "Get movie failed", null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable int id) {
        Object user = ms.delete(id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Movie deleted", user));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "Movie not deleted", null));
    }
}
