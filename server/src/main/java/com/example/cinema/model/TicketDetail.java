package com.example.cinema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket_detail")
public class TicketDetail {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket", referencedColumnName = "id")
    private Ticket ticket;

    @Column
    private int quantity;
}
