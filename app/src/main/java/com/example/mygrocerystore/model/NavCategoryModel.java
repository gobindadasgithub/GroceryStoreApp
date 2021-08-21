package com.example.mygrocerystore.model;

public class NavCategoryModel {
    private  String name,description,discount,img_uri;


    public NavCategoryModel() {
    }
    public NavCategoryModel(String name, String description, String discount, String img_uri) {
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.img_uri = img_uri;
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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getImg_uri() {
        return img_uri;
    }

    public void setImg_uri(String img_uri) {
        this.img_uri = img_uri;
    }
}
