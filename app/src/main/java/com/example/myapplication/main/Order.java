package com.example.myapplication.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Order {

    private String id;
    private List<Item> items;
    private String orderdate;

    public Order() {}
    public Order(String id, List<Item> items) {
        this.id = id; this.items = items;
    }

    public Order(String id, List<Item> items,String orderdate) {
        this.id = id; this.items = items;
        this.orderdate=orderdate;
    }

    public static String generateDate(){
        String Date_order = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        return Date_order;
    }
    public static String generateId() {
        return "ORD_" + (long)(100000000 + Math.random() * 999999999);
    }
    public static Order makeNew() {
        return new Order(generateId(), new ArrayList<>());
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setItems(List<Item> items){
        this.items = items;
    }
    public List<Item> getItems(){ return this.items; }

    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }
}