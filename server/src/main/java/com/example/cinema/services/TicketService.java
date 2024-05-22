package com.example.cinema.services;

import com.example.cinema.model.Ticket;
import com.example.cinema.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TicketService extends BaseApi {

    @Autowired
    private TicketRepository tr;

    @Override
    public List<Object> findAll() {
        return Collections.singletonList(tr.findAll());
    }

    @Override
    public Object save(Object obj) {
        return tr.save((Ticket) obj);
    }

    @Override
    public Object delete(int id) {
        Ticket ticket = tr.findById(id).orElseThrow(null);
        if (ticket != null) {
            tr.deleteById(id);
        }
        return null;
    }
}
