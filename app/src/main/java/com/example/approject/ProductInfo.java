package com.example.approject;

public class ProductInfo {
    String name;
    int price;
    public ProductInfo(String name , int price)
    {
        this.name=name;
        this.price=price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
