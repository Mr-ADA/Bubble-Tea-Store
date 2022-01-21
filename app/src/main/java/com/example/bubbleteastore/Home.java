package com.example.bubbleteastore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home extends AppCompatActivity {

    private Button checkMenu, confirmationBtn;
    private Product myProduct = (Product) this.getApplication();

    private RecyclerView orderList;
    private RecyclerView.Adapter orderAdapter;
    private RecyclerView.LayoutManager listLayoutManager;
    private List<Order> bbtOrders = myProduct.getOrderList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideActionBar();
        initMenu();
        goToMenu();
        createRecyclerView();
        goToConfirmation();
    }

    private void hideActionBar(){
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
    }

    private void goToMenu(){
        checkMenu = findViewById(R.id.btn_check_menu);
        checkMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Menu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("product", (Parcelable) myProduct);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void createRecyclerView(){
        List<Order> orders = new ArrayList<Order>();

        orderList = findViewById(R.id.lv_ordered_item_list);
        orderList.setHasFixedSize(true);

        listLayoutManager = new LinearLayoutManager(this);
        orderList.setLayoutManager(listLayoutManager);

        orderAdapter = new OrderAdapter(Home.this, orders);
        orders.addAll(bbtOrders);

        orderAdapter.notifyDataSetChanged();
        orderList.setAdapter(orderAdapter);
    }

    private List<BubbleTea> initMenu(){
        List<BubbleTea> bbtList = new ArrayList<>();

        BubbleTea bbt1 = new BubbleTea(1,"Bubble Milk Tea", 6.0, this.getResources().getIdentifier("bubble_milk_tea","drawable",getPackageName()));
        BubbleTea bbt2 = new BubbleTea(2,"Bubble Green Tea", 8.0, this.getResources().getIdentifier("bubble_green_tea","drawable",getPackageName()));
        BubbleTea bbt3 = new BubbleTea(3,"Coffee Milk", 5.0, this.getResources().getIdentifier("coffee_milk","drawable",getPackageName()));
        BubbleTea bbt4 = new BubbleTea(4,"Roasted Milk Tea", 8.0, this.getResources().getIdentifier("roasted_milk_tea","drawable",getPackageName()));
        BubbleTea bbt5 = new BubbleTea(5,"Thai Tea", 5.0, this.getResources().getIdentifier("thai_tea","drawable",getPackageName()));
        BubbleTea bbt6 = new BubbleTea(6,"Jasmine Peach Tea", 4.0, this.getResources().getIdentifier("jasmine_peach_tea","drawable",getPackageName()));
        BubbleTea bbt7 = new BubbleTea(7,"Bubble Taro Tea", 7.0, this.getResources().getIdentifier("bubble_taro_tea","drawable",getPackageName()));
        BubbleTea bbt8 = new BubbleTea(8,"Ice Milk Tea", 3.0, this.getResources().getIdentifier("ice_milk_tea","drawable",getPackageName()));
        BubbleTea bbt9 = new BubbleTea(9,"Ice Tea", 2.0, this.getResources().getIdentifier("ice_tea_o","drawable",getPackageName()));

        bbtList.addAll(Arrays.asList(bbt1, bbt2, bbt3, bbt4, bbt5, bbt6,bbt7,bbt8,bbt9));
        Product.setMenuList(bbtList);

        return bbtList;
    }

    private void goToConfirmation(){
        confirmationBtn = findViewById(R.id.btn_order);
        confirmationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BBT Details", bbtOrders.get(0).getIceLevel() + " " + bbtOrders.get(0).getSugarLevel() + " " + bbtOrders.get(0).getSize() + " ");
                Intent orderIntent = new Intent(Home.this, ConfirmOrder.class);
                startActivity(orderIntent);
            }
        });
    }
}