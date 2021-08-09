package com.entity;

import javax.persistence.*;
@Entity
@Table(name = "treasury")
public class Treasury {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String acc;
    @OneToOne(mappedBy="treasury")
    private Bank bank;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }
}
