package com.example.bubbleteastore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.List;

public class CustomizeBubbleTea extends AppCompatActivity {

    private Button isSmall, isMedium, isLarge, isLessIce, isNormalIce;
    private SeekBar sugarLevel;
    Product myProducts = (Product) this.getApplication();
    private List<Order> myOrdersList = myProducts.getOrderList();
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_bubble_tea);
        Intent myIntent = getIntent();
        order = (Order) myIntent.getParcelableExtra("getOrder");
        customizeIce();
        customizeSize();
        replaceOrder(order);
    }

    private void customizeIce(){
        isLessIce = findViewById(R.id.btn_custom_ice_less);
        isNormalIce = findViewById(R.id.btn_custom_ice_normal);

        if(isNormalIce.callOnClick()){
            order.setIceLevel('n');
            isLessIce.setClickable(false);
        }
        if(isLessIce.callOnClick()){
            order.setIceLevel('l');
            isNormalIce.setClickable(false);
        }
    }

    private void customizeSize(){
        isSmall = findViewById(R.id.btn_custom_size_small);
        isMedium = findViewById(R.id.btn_custom_size_medium);
        isLarge = findViewById(R.id.btn_custom_size_large);

        if(isSmall.callOnClick()){
            order.setSize('s');
            isMedium.setClickable(false);
            isLarge.setClickable(false);
        }
        if(isMedium.callOnClick()){
            order.setSize('m');
            isSmall.setClickable(false);
            isLarge.setClickable(false);
        }
        if(isLarge.callOnClick()){
            order.setSize('l');
            isSmall.setClickable(false);
            isMedium.setClickable(false);
        }
    }

    private void customizeSugarLevel(){
        sugarLevel = findViewById(R.id.sb_sugar_level);
    }

    private void replaceOrder(Order order){
        if(myOrdersList.contains(order)){
            myOrdersList.set(myOrdersList.indexOf(order), order);
        }
    }
}