package com.example.mygrocerystore.model;

public class PopularModel {
    String name;
    String description;
    String ratingber;
    String discount;
    String type;
    String image_url;
    public  PopularModel(){

    }

    public PopularModel(String name, String description, String ratingber, String discount, String type, String image_url) {
        this.name = name;
        this.description = description;
        this.ratingber = ratingber;
        this.discount = discount;
        this.type = type;
        this.image_url = image_url;
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

    public String getRatingber() {
        return ratingber;
    }

    public void setRatingber(String ratingber) {
        this.ratingber = ratingber;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
