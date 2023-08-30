package com.matthewcurtner.grocerybackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Grocery {
    @Id
    private int id;
    private String name;
    private String imageUrl;
    private String price;
    private String currency;
    private String volumePrice;
    private String volumeCurrency;
    private String store;

    public Grocery() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getVolumePrice() {
        return volumePrice;
    }

    public void setVolumePrice(String volumePrice) {
        this.volumePrice = volumePrice;
    }

    public String getVolumeCurrency() {
        return volumeCurrency;
    }

    public void setVolumeCurrency(String volumeCurrency) {
        this.volumeCurrency = volumeCurrency;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Grocery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price='" + price + '\'' +
                ", currency='" + currency + '\'' +
                ", volumePrice='" + volumePrice + '\'' +
                ", volumeCurrency='" + volumeCurrency + '\'' +
                ", store='" + store + '\'' +
                '}';
    }
}
