package com.ux.gs2n.model.show;

import com.ux.gs2n.model.movie.Movie;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "times_show")
public class TimeShow implements ITimeShow {
    @Id
    @Column
    private int id;

    @Column(name = "time_start")
    private LocalDate timeStrat;

    @OneToOne
    private Movie movie;
    
    @OneToOne
    private Room room;

    public TimeShow() {
    }
}
