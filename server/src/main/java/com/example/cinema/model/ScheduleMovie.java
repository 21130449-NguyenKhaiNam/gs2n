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
@Table(name = "schedule_movie")
public class ScheduleMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scheduleCinema", referencedColumnName = "id")
    private ScheduleCinema scheduleCinema;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie", referencedColumnName = "id")
    private Movie movie;
}
