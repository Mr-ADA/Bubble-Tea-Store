package com.example.bubbleteastore;

public class BubbleTea {

    private int id;
    private String productName;
    private double price;
    private int imageSrc;

    public BubbleTea(int id, String productName, double price, int imageSrc){
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.imageSrc = imageSrc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getImageSrc() {
        return imageSrc;
    }

}