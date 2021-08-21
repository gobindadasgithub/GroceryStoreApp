package com.example.mygrocerystore.model;

public class RecommandadModel {
    private  String name,description,rathing,img_ur;
    private  int price;

    public RecommandadModel() {
    }

    public RecommandadModel(String name, String description, String rathing, String img_ur, int price) {
        this.name = name;
        this.description = description;
        this.rathing = rathing;
        this.img_ur = img_ur;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRathing() {
        return rathing;
    }

    public void setRathing(String rathing) {
        this.rathing = rathing;
    }

    public String getImg_ur() {
        return img_ur;
    }

    public void setImg_ur(String img_ur) {
        this.img_ur = img_ur;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
