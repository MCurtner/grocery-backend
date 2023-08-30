package com.matthewcurtner.grocerybackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("grocery")
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

    public Grocery(int id) {
        this.id = id;
        this.name = "item1";
        this.imageUrl = "some image url";
        this.price = "1,00";
        this.currency = "Kč";
        this.volumePrice = "11,45";
        this.volumeCurrency = "Kč/1 ks";
        this.store = "StoreName";
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
}
