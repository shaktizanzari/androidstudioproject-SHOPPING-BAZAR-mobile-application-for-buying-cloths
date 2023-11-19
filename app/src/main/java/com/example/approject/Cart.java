package com.example.approject;

import java.util.ArrayList;

public class Cart {
    private static Cart instance;

    private ArrayList<ProductInfo> items;

    private Cart() {
        items = new ArrayList<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public void addItem(String item, int price)
    {
        ProductInfo pi=new ProductInfo(item, price);
        items.add(pi);
    }

    public ArrayList<ProductInfo> getItems() {
        return items;
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (ProductInfo item : items) {
            total+= item.getPrice();
        }
        return total;
    }
}
