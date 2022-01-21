package com.example.bubbleteastore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<BubbleTea> listOfBubbleTea;
    private Product product;

    public ListAdapter(List<BubbleTea> listOfBubbleTea, Product product){
        this.listOfBubbleTea = listOfBubbleTea;
        this.product = product;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_bubble_tea, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BubbleTea bbt;
        bbt = listOfBubbleTea.get(position);
        int orderId = listOfBubbleTea.size();
        holder.iv_bbtPict.setImageResource(bbt.getImageSrc());
        holder.tv_bbtName.setText(bbt.getProductName());
        holder.tv_bbtPrice.setText("$"+ (int) bbt.getPrice());
        holder.cvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = new Order(orderId, bbt);
                product.addOrder(order);
                Log.d("TEST_ORDER", "ORDER SIZE: " + product.getOrderList().size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfBubbleTea.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_bbtPict;
        TextView tv_bbtName;
        TextView tv_bbtPrice;
        CardView cvMenu;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            iv_bbtPict = itemView.findViewById(R.id.iv_menu_pict);
            tv_bbtName = itemView.findViewById(R.id.tv_bbt_name);
            tv_bbtPrice = itemView.findViewById(R.id.tv_bbt_price);
            cvMenu = itemView.findViewById(R.id.cv_menu_view);
        }
    }
}