package com.example.bubbleteastore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    private Button backButton;
    private List<BubbleTea> bbtList;
    private Product product;

    private RecyclerView allTimeFavouriteList;
    private RecyclerView.Adapter listAllTimeFavAdapter;
    private RecyclerView.LayoutManager allTimeListLayout;

    private RecyclerView otherMenuList;
    private RecyclerView.Adapter listOtherMenuAdapter;
    private RecyclerView.LayoutManager otherListLayout;

    private static final String TAG = "AllTimeFavourite";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        hideActionBar();
        getBBTList();
        backButton();
        setAllTimeList();
        setOtherList();
    }

    private void hideActionBar(){
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
    }

    private void setAllTimeList(){
        List<BubbleTea> AllTimeList = getAllTimeFavourite();
        allTimeFavouriteList = findViewById(R.id.lv_all_time_favourite);

        allTimeListLayout = new LinearLayoutManager(this);
        allTimeFavouriteList.setLayoutManager(allTimeListLayout);

        listAllTimeFavAdapter = new ListAdapter(AllTimeList, product);
        allTimeFavouriteList.setAdapter(listAllTimeFavAdapter);
    }

    private void setOtherList(){
        List<BubbleTea> otherMenu = getOtherMenu();

        otherMenuList = findViewById(R.id.lv_other_drinks_list);
        otherListLayout = new LinearLayoutManager(this);
        otherMenuList.setLayoutManager(otherListLayout);

        listOtherMenuAdapter = new ListAdapter(otherMenu, product);
        otherMenuList.setAdapter(listOtherMenuAdapter);
    }

    private void backButton(){
        backButton = findViewById(R.id.btn_menu_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void getBBTList(){
        bbtList = Product.getMenuList();
    }

    private List<BubbleTea> getAllTimeFavourite(){
        List<BubbleTea> allTimeFav = new ArrayList<>();
        for(BubbleTea bbt: bbtList){
            if(bbt.getId() == 1){
                allTimeFav.add(bbt);
            }
        }
        return allTimeFav;
    }

    private List<BubbleTea> getOtherMenu(){
        List<BubbleTea> other = new ArrayList<>();
        for(BubbleTea bbt: bbtList){
            if(bbt.getId() != 1){
                other.add(bbt);
            }
        }
        return other;
    }
}