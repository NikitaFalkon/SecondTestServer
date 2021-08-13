package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "inn")
    private String inn;
    @Column(name = "kpp")
    private String kpp;
    @Column(name = "cname")
    private String cname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    /*public List<Document> getRecipientDocuments() {
        return recipientDocuments;
    }*/

    /*public void setRecipientDocuments(List<Document> recipientDocuments) {
        this.recipientDocuments = recipientDocuments;
    }*/

    /*public List<Document> getPayerDocuments() {
        return payerDocuments;
    }*/

   /* public void setPayerDocuments(List<Document> payerDocuments) {
        this.payerDocuments = payerDocuments;
    }*/

}
