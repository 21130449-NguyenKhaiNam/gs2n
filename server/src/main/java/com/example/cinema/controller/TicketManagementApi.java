package com.example.cinema.controller;

import com.example.cinema.model.ResponseObject;
import com.example.cinema.model.User;
import com.example.cinema.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketManagementApi {
    @Autowired
    private TicketService ts;

    @GetMapping("")
    public ResponseEntity<ResponseObject> findAll() {
        List<Object> findAll = ts.findAll();

        if (!findAll.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Find all successfully", findAll));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "Find all failed", findAll));
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseObject> save(@RequestBody Object obj) {
        User user = (User) ts.save(obj);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Get ticket successfully", user));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "Get ticket failed", null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable int id) {
        Object user = ts.delete(id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Ticket deleted", user));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "Ticket not deleted", null));
    }
}
