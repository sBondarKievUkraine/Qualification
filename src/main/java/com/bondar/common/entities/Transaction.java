package com.bondar.common.entities;

import java.util.Currency;

public class Transaction implements java.io.Serializable{
    private String card;
    private String place;
    private Float amount;
    private Currency currency;
    private Client client;
    private Integer client_inn;

    public Integer getClient_inn() {
        return client_inn;
    }

    public void setClient_inn(Integer client_inn) {
        this.client_inn = client_inn;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = Currency.getInstance(currency);
    }


}
