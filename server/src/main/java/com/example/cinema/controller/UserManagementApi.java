package com.example.cinema.controller;

import com.example.cinema.model.ResponseObject;
import com.example.cinema.model.User;
import com.example.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserManagementApi {
    @Autowired
    private UserService us;

    @GetMapping("")
    public ResponseEntity<ResponseObject> findAll() {
        List<Object> findAll = us.findAll();

        if (!findAll.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Find all successfully", findAll));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "Find all failed", findAll));
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseObject> save(@RequestBody Object obj) {
        User user = (User) us.save(obj);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Get user successfully", user));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "Get user failed", null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable int id) {
        Object user = us.delete(id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "User deleted", user));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "User not deleted", null));
    }

    @GetMapping("/login")
    public ResponseEntity<ResponseObject> login(@RequestParam String username, @RequestParam String password) {
        User userLogin = us.login(username, password);
        if (userLogin != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Login successfully", userLogin));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "Login failed", null));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseObject> updateUser(@RequestBody User user) {
        User userUpdated = us.updateUser(user);

        if (userUpdated != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "User updated", userUpdated));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "Use not updated", null));
    }

    @GetMapping("/search/{username}")
    public ResponseEntity<ResponseObject> searchUser(@PathVariable String username) {
        User userSearch = us.searchUser(username);

        if (userSearch != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Found successfully", userSearch));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("NOT_FOUND", "Found failed", null));
    }
}
