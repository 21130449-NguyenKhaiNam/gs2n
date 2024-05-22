package com.example.cinema.controller;

import com.example.cinema.model.*;
import com.example.cinema.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinema")
public class CinemaManagementApi {
    @Autowired
    private CinemaService cs;

    @GetMapping("")
    public ResponseEntity<ResponseObject> findAll() {
        List<Object> findAll = cs.findAll();

        if (!findAll.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Find all successfully", findAll));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "Find all failed", findAll));
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseObject> save(@RequestBody Object obj) {
        User user = (User) cs.save(obj);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Get cinema successfully", user));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "Get cinema failed", null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable int id) {
        Object user = cs.delete(id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Cinema deleted", user));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(

                new ResponseObject("NOT_FOUND", "Cinema not deleted", null));
    }

    @GetMapping("/infoCinema")
    public ResponseEntity<ResponseObject> findInfoScheduleCinema(@RequestParam Cinema cinema) {
        List<ScheduleCinema> result = cs.findInfoScheduleCinema(cinema);

        if (!result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Get info schedule cinema successfully", result));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(

                new ResponseObject("NOT_FOUND", "Get info schedule cinema failed", null));
    }

    @GetMapping("/infoMovie")
    public ResponseEntity<ResponseObject> findInfoScheduleMovie(@RequestParam Cinema cinema, @RequestParam Movie movie) {
        List<ScheduleMovie> result = cs.findInfoScheduleMovie(cinema, movie);

        if (!result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Get info schedule movie successfully", result));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(

                new ResponseObject("NOT_FOUND", "Get info schedule movie failed", null));
    }

    @GetMapping("/infoCinema/{id}")
    public ResponseEntity<ResponseObject> findInfoCinema(@PathVariable int id) {
        Cinema cinema = cs.findInfoCinema(id);

        if (cinema != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Get info cinema successfully", cinema));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(

                new ResponseObject("NOT_FOUND", "Get info movie failed", null));
    }

}
