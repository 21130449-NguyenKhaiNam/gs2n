package com.example.cinema.services;

import com.example.cinema.model.User;
import com.example.cinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService extends BaseApi {
    @Autowired
    private UserRepository ur;

    @Override
    public List<Object> findAll() {
        return Collections.singletonList(ur.findAll());
    }

    @Override
    public Object save(Object obj) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = (User) obj;
        String hashesPass = encoder.encode(user.getPassword());
        user.setPassword(hashesPass);

        return ur.save(user);
    }

    @Override
    public User delete(int id) {
        User user = ur.findById(id).orElseThrow(null);
        if(user != null){
            ur.deleteById(id);
        }
        return null;
    }

    public User login(String username, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User findUserByUs = searchUser(username);
        if (encoder.matches(findUserByUs.getPassword(), password)) {
            return findUserByUs;
        }
        return null;
    }

    public User updateUser(User user) {
        String username = user.getUsername();
        User findUserByUsername = searchUser(username);

        findUserByUsername = user;
        save(findUserByUsername);

        return findUserByUsername;
    }

    public User searchUser(String username) {
        return ur.findByUsername(username);
    }
}
