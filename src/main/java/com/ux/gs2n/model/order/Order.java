package com.ux.gs2n.model.order;

import com.ux.gs2n.model.account.Account;
import com.ux.gs2n.model.movie.Movie;
import com.ux.gs2n.model.show.TimeShow;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column
    private String id;

    @OneToOne
    @JoinColumn(name = "id_account")
    private Account account;

    @OneToOne
    @JoinColumn(name = "id_movie")
    private Movie movie;

    @OneToOne
    @JoinColumn(name = "id_time_show")
    private TimeShow timeShow;

    public Order() {
    }
}
