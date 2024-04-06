package com.ux.gs2n.model.account;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements IRole {
    @Id
    @Column
    private int id;

    @Column
    private String name;

    public Role() {
    }
}
