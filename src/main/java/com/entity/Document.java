package com.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "number")
    private String number;
    @Column(name = "date")
    private String date;
    @Column(name = "guid")
    private String guid;
    @Column(name = "type")
    private String type;
    @Column(name = "amount")
    private BigDecimal amount;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="bankrec_id", nullable=false)
    private Bank recipientBank;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="bankpay_id", nullable=false)
    private Bank payerBank;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="orgrec_id", nullable=false)
    private Organization recipientOrganization;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="orgpay_id", nullable=false)
    private Organization payerOrganization;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Bank getRecipientBank() {
        return recipientBank;
    }

    public void setRecipientBank(Bank recipientBank) {
        this.recipientBank = recipientBank;
    }

    public Bank getPayerBank() {
        return payerBank;
    }

    public void setPayerBank(Bank payerBank) {
        this.payerBank = payerBank;
    }

    public Organization getRecipientOrganization() {
        return recipientOrganization;
    }

    public void setRecipientOrganization(Organization recipientOrganization) {
        this.recipientOrganization = recipientOrganization;
    }

    public Organization getPayerOrganization() {
        return payerOrganization;
    }

    public void setPayerOrganization(Organization payerOrganization) {
        this.payerOrganization = payerOrganization;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String GUID) {
        this.guid = GUID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal sum) {
        this.amount = sum;
    }
}
