package com.example.bubbleteastore;

public class Order {

    private BubbleTea bbt;
    private char size;
    private char iceLevel;
    private double sugarLevel;
    private int quantity;

    public Order(BubbleTea bbt, char size, char iceLevel, double sugarLevel){
        this.bbt = bbt;
        this.size = size;
        this.iceLevel = iceLevel;
        this.sugarLevel = sugarLevel;
        this.quantity = 1;
    }

    public Order(BubbleTea bbt){
        this(bbt, 'M', 'N', 0.1);
    }

    public BubbleTea getBbt() {
        return bbt;
    }

    public void setBbt(BubbleTea bbt) {
        this.bbt = bbt;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public char getIceLevel() {
        return iceLevel;
    }

    public void setIceLevel(char iceLevel) {
        this.iceLevel = iceLevel;
    }

    public double getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(double sugarLevel) {
        this.sugarLevel = sugarLevel;
    }
}