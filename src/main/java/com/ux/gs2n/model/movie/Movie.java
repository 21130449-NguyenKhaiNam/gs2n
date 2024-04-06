package com.ux.gs2n.model.movie;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie implements IMovie {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name = "date_updated")
    private LocalDate dateUpdate;

    @OneToMany
    @JoinColumn(name = "caterogies")
    private List<Category> categories;

    public Movie() {
    }

}
