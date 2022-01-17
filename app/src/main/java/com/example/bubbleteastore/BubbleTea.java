package com.example.bubbleteastore;

import android.os.Parcel;
import android.os.Parcelable;

public class BubbleTea implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(productName);
        dest.writeDouble(price);
        dest.writeInt(imageSrc);
    }

    public static final Creator<BubbleTea> CREATOR = new Creator<BubbleTea>() {
        @Override
        public BubbleTea createFromParcel(Parcel source) {
            return new BubbleTea(source);
        }

        @Override
        public BubbleTea[] newArray(int size) {
            return new BubbleTea[size];
        }
    };

    private BubbleTea(Parcel in){
        id = in.readInt();
        productName = in.readString();
        price = in.readDouble();
        imageSrc = in.readInt();
    }

}