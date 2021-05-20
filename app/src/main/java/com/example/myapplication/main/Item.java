package com.example.myapplication.main;

public class Item {
    private String name;
    private String price;
    private String rating;
    private int resourceId;

    public Item(){

    }
    public Item(String name, int resourceId) {
        this.name = name;
        this.resourceId = resourceId;
    }
    public Item(String name, String price, String rating, int resourceId) {
        this.name       = name;
        this.price      = price;
        this.rating     = rating;
        this.resourceId = resourceId;
    }

    public String getName      () { return name      ; }
    public int    getResourceId() { return resourceId; }
    public String getPrice     () { return price     ; }
    public String getRating    () { return rating    ; }

    public void setName(String name) { this.name =name; }
    public void setResourceId(int resourceId) { this.resourceId = resourceId; }
    public void setPrice(String price) { this.price =price; }
    public void setRating(String rating) { this.rating = rating; }

}
