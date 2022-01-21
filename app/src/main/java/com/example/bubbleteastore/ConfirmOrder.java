package com.example.bubbleteastore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class ConfirmOrder extends AppCompatActivity {

    Product myProduct = (Product) this.getApplication();
    List<Order> myOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        hideActionBar();

        myOrders = myProduct.getOrderList();
        createOrderItems(myOrders);
    }

    private void hideActionBar(){
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
    }

    @SuppressLint("SetTextI18n")
    private void createOrderItems(List<Order> listOfOrders){
        TableLayout myOrdersTable = findViewById(R.id.tl_list_of_my_orders);
        myOrdersTable.setStretchAllColumns(true);

        for(Order myOrder: listOfOrders){
            BubbleTea bbt = myOrder.getBbt();
            String name = myOrder.getBbt().getProductName();
            double pricePerUnit = myOrder.getBbt().getPrice();
            int quantity = myOrder.getQuantity();
            double totalPrice = quantity * pricePerUnit;

            TableRow newRow = new TableRow(this);
            TextView tvProductName = createTextView(this, name, 20);
            TextView tvProductPrice = createTextView(this, "$" + totalPrice, 20);
            TextView tvProductQuantity = createTextView(this, quantity + "x", 20);

            newRow.addView(tvProductQuantity);
            newRow.addView(tvProductName);
            newRow.addView(tvProductPrice);

            myOrdersTable.addView(newRow);

            Log.d("Order Details", "BBT Details" + myOrder.getIceLevel() + " " + myOrder.getIceLevel() + " " + myOrder.getSugarLevel());
        }
    }

    private TextView createTextView(Context context, String text, int padding){
        TextView newTextView = new TextView(context);
        newTextView.setText(text);
        newTextView.setPadding(padding, padding, padding, padding);
        newTextView.setTextColor(Color.BLACK);
        newTextView.setTextSize(20);
        return newTextView;
    }
}