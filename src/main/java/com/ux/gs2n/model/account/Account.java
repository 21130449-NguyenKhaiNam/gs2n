package com.ux.gs2n.model.account;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "accounts")
public class Account implements IAccount{
    @Id
    @Column
    private String id;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String encodePass;
    @OneToOne
    @JoinColumn
    private Gender idGender;

    @OneToOne
    @JoinColumn(name = "id_role")
    private Role idRole;
    @Column
    private LocalDate dob;

    public Account() {}
}
