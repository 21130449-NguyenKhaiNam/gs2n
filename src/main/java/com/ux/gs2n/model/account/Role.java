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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
