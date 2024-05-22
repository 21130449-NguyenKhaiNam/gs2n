package com.example.cinema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String fullname;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private int visi;
    @PrePersist
    void preInsert() {
        this.visi = 1;
    }
}
