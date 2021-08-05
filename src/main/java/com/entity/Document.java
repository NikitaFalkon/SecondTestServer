package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String number;
    private String date;
    private String GUID;
    private String type;
    private String sum;
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

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
