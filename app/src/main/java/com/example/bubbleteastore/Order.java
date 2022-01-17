package com.example.bubbleteastore;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(bbt, flags);
        dest.writeString(Character.toString(size));
        dest.writeString(Character.toString(iceLevel));
        dest.writeDouble(sugarLevel);
        dest.writeInt(quantity);
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    private Order(Parcel in){
        bbt = (BubbleTea) in.readParcelable(getClass().getClassLoader());
        size = in.readString().charAt(0);
        iceLevel = in.readString().charAt(0);
        sugarLevel = in.readDouble();
        quantity = in.readInt();
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