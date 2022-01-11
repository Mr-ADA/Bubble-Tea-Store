package com.example.bubbleteastore;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product extends Application {

    private static List<BubbleTea> menuList = new ArrayList<BubbleTea>();
    private static int nextId = menuList.size();
    private static List<Order> orderList = new ArrayList<>();

    public static List<BubbleTea> getMenuList(){
        return menuList;
    }

    public static void setMenuList(List<BubbleTea> menuList) {
        Product.menuList = menuList;
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public static void setOrderList(List<Order> orderList) {
        Product.orderList = orderList;
    }

    public static void addOrder(Order order){
        orderList.add(order);
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Product.nextId = nextId;
    }
}
