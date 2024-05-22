package com.example.cinema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category", referencedColumnName = "id")
    private Category category;
    @Column
    private int price;
    @Column
    private int salePrice;
    @Column
    private int rating;
    @Column
    private String status;
    @Column
    private Date createdAt;
    @Column
    private int visi;
    @PrePersist
    void preInsert() {
        this.visi = 1;
    }
}
