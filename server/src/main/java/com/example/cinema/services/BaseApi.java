package com.example.cinema.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseApi {

    protected abstract List<Object> findAll();
    protected abstract Object save(Object obj);
    protected abstract Object delete(int id);
}
