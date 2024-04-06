package com.ux.gs2n.model.show;

import jakarta.persistence.*;

@Entity
@Table(name = "chairs")
public class Chair implements IChair {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    public Chair() {}
}
