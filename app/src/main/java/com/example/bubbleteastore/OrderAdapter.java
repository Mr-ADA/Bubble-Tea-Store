package com.example.bubbleteastore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder>{

    private Context context;
    private List<Order> listOfOrders;
    int orderQuantity;

    public OrderAdapter(Context context, List<Order> listOfOrders){
        this.context = context;
        this.listOfOrders = listOfOrders;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_order_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Order order = listOfOrders.get(position);
        BubbleTea tea = order.getBbt();
        orderQuantity = order.getQuantity();
        holder.bbtImg.setImageResource(tea.getImageSrc());
        holder.productName.setText(tea.getProductName());
        holder.productPrice.setText("$"+tea.getPrice());
        holder.productQuantity.setText(Integer.toString(orderQuantity));
        order.setQuantity(Integer.parseInt(holder.productQuantity.getText().toString()));

        holder.customizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CustomizeBubbleTea.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("getOrder", order);
                context.startActivity(intent);
            }
        });

        holder.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderQuantity++;
                holder.productQuantity.setText(Integer.toString(orderQuantity));
                order.setQuantity(orderQuantity);
            }
        });

        holder.fabRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderQuantity--;
                holder.productQuantity.setText(Integer.toString(orderQuantity));
                order.setQuantity(orderQuantity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfOrders.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView bbtImg;
        TextView productName, productPrice, productQuantity;
        Button customizeBtn;
        FloatingActionButton fabAdd, fabRemove;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bbtImg = itemView.findViewById(R.id.iv_menu_pict);
            productName = itemView.findViewById(R.id.tv_order_product_name);
            productPrice = itemView.findViewById(R.id.tv_order_product_price);
            productQuantity = itemView.findViewById(R.id.tv_order_quantity);
            customizeBtn = itemView.findViewById(R.id.btn_customize_bbt);
            fabAdd = itemView.findViewById(R.id.fab_add_bbt);
            fabRemove = itemView.findViewById(R.id.fab_remove_bbt);
        }
    }
}