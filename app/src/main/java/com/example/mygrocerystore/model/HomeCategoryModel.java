package com.example.mygrocerystore.model;

public class HomeCategoryModel {
    private  String name,type,img_uri;

    public HomeCategoryModel() {

    }

    public HomeCategoryModel(String name, String type, String img_uri) {
        this.name = name;
        this.type = type;
        this.img_uri = img_uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg_uri() {
        return img_uri;
    }

    public void setImg_uri(String img_uri) {
        this.img_uri = img_uri;
    }
}
