package com.example.bubbleteastore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.List;

public class CustomizeBubbleTea extends AppCompatActivity {

    private Button btnIsSmall, btnIsMedium, btnIsLarge, btnIsLessIce, btnIsNormalIce, btnApply;
    private SeekBar sugarLevel;
    private Product myProducts = (Product) this.getApplication();
    private List<Order> myOrdersList = myProducts.getOrderList();
    private Order order;
    private double custSugarLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_bubble_tea);
        Intent myIntent = getIntent();
        order = (Order) myIntent.getParcelableExtra("getOrder");
        customizeIce();
        customizeSize();
        customizeSugarLevel();
        backToHome();
    }

    private void customizeIce(){
        btnIsLessIce = findViewById(R.id.btn_custom_ice_less);
        btnIsNormalIce = findViewById(R.id.btn_custom_ice_normal);

        btnIsNormalIce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.setIceLevel('n');
                btnIsLessIce.setBackgroundColor(Color.GRAY);
                btnIsNormalIce.setBackgroundColor(Color.rgb(99, 224, 68));
            }
        });

        btnIsLessIce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                order.setIceLevel('l');
                btnIsNormalIce.setBackgroundColor(Color.GRAY);
                btnIsLessIce.setBackgroundColor(Color.rgb(99, 224, 68));
            }
        });
    }

    private void customizeSize(){
        btnIsSmall = findViewById(R.id.btn_custom_size_small);
        btnIsMedium = findViewById(R.id.btn_custom_size_medium);
        btnIsLarge = findViewById(R.id.btn_custom_size_large);

        btnIsSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.setSize('s');
                btnIsSmall.setBackgroundColor(Color.rgb(99, 224, 68));
                btnIsMedium.setBackgroundColor(Color.GRAY);
                btnIsLarge.setBackgroundColor(Color.GRAY);
            }
        });

        btnIsMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.setSize('m');
                btnIsSmall.setBackgroundColor(Color.GRAY);
                btnIsMedium.setBackgroundColor(Color.rgb(99, 224, 68));
                btnIsLarge.setBackgroundColor(Color.GRAY);
            }
        });

        btnIsLarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.setSize('l');
                btnIsSmall.setBackgroundColor(Color.GRAY);
                btnIsMedium.setBackgroundColor(Color.GRAY);
                btnIsLarge.setBackgroundColor(Color.rgb(99, 224, 68));
            }
        });
    }

    private void customizeSugarLevel(){
        sugarLevel = findViewById(R.id.sb_sugar_level);
        sugarLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                custSugarLevel = (double) progress * 25 / 100;
                Log.d("Sugar Level", "User sugar level: " + custSugarLevel + "%");
                order.setSugarLevel(custSugarLevel);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    //change the order inside the list from here

    private void customizeBBT(int index, Order myOrder){
        myOrdersList.set(index, myOrder);
    }

    private boolean customizeBBT(Order myOrder){
        boolean flag = false;
        int index;
        for(Order order : myOrdersList){
            if(order.getId() == myOrder.getId()){
                index = myOrdersList.indexOf(order);
                customizeBBT(index, myOrder);
                flag = true;
                break;
            }
        }
        return flag;
    }

    private void backToHome(){
        btnApply = findViewById(R.id.btn_apply_customization);
        btnApply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(customizeBBT(order)) {
                    Intent intent = new Intent(CustomizeBubbleTea.this, Home.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    CustomizeBubbleTea.this.startActivity(intent);
                }else{
                    Toast.makeText(CustomizeBubbleTea.this, "Order is not found!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}