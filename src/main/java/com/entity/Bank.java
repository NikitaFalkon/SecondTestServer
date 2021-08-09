package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String account;
    private String bic;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="treasury_id", nullable=false)
    private Treasury treasury;
    @OneToMany (cascade=CascadeType.ALL, mappedBy="recipientBank")
    private List<Document> recipientDocuments;
    @OneToMany (cascade=CascadeType.ALL, mappedBy="payerBank")
    private List<Document> payerDocuments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public List<Document> getRecipientDocuments() {
        return recipientDocuments;
    }

    public void setRecipientDocuments(List<Document> recipientDocuments) {
        this.recipientDocuments = recipientDocuments;
    }

    public List<Document> getPayerDocuments() {
        return payerDocuments;
    }

    public void setPayerDocuments(List<Document> payerDocuments) {
        this.payerDocuments = payerDocuments;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Treasury getTreasury() {
        return treasury;
    }

    public void setTreasury(Treasury treasury) {
        this.treasury = treasury;
    }
}
