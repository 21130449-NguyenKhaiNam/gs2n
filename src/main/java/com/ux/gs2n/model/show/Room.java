package com.ux.gs2n.model.show;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rooms")
public class Room implements IRoom {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany
    @JoinColumn(name = "chairs")
    private List<Chair> chairs;

    @Column
    private long quality;

    public Room() {}
}
