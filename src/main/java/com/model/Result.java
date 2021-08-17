package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Recipient")
    private long rec;
    @JsonProperty("Payer")
    private long pay;

    public Result(String name, long pay, long rec) {
        this.rec = rec;
        this.name = name;
        this.pay = pay;
    }

    public long getRec() {
        return rec;
    }

    public void setRec(long rec) {
        this.rec = rec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPay() {
        return pay;
    }

    public void setPay(long pay) {
        this.pay = pay;
    }
    @Override
    public String toString() {
        return "name = "+name+", rec = " +rec+ ", pay = " +pay +";";
    }
}
