package com.ux.gs2n.model.account;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "genders")
public class Gender implements IGender {

    @Id
    @Column
    private int id;

    @Column
    private String name;

    public Gender() {}

    public int getId() {
        return id;
    }
}
