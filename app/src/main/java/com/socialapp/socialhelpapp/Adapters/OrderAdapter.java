package com.socialapp.socialhelpapp.Adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.socialapp.socialhelpapp.Models.OrderList_Model;
import com.socialapp.socialhelpapp.Models.ProductList_Model;
import com.socialapp.socialhelpapp.MyParcelable;
import com.socialapp.socialhelpapp.ProductDetailActivity;
import com.socialapp.socialhelpapp.R;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private List<OrderList_Model> orderlist;

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public TextView mNameView, mPriceView;
        public TextView mQuantityView, mDateView;
        public ImageView mImageView;
        public CoordinatorLayout container;
        public OrderViewHolder(View view) {
            super(view);
            mNameView = view.findViewById(R.id.Text_orderbar);
            mPriceView = view.findViewById(R.id.Price_orderbar);
            mQuantityView = view.findViewById(R.id.Quantity_orderbar);
            mDateView = view.findViewById(R.id.Date_orderbar);
            mImageView = view.findViewById(R.id.Image_orderbar);
            container = view.findViewById(R.id.order_bar);
        }
    }

    public OrderAdapter(List<OrderList_Model> orderlist) {
        this.orderlist = orderlist;
    }

    @NonNull
    @Override
    public OrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View orderview = LayoutInflater.from(parent.getContext()).inflate(R.layout.yourorderbar, parent, false);
        return new OrderAdapter.OrderViewHolder(orderview);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.OrderViewHolder holder, int position) {
        final OrderList_Model order = orderlist.get(position);
        holder.mNameView.setText(order.getProductname());
        holder.mPriceView.setText(order.getProductprice());
        holder.mQuantityView.setText(order.getProductquantity());
        holder.mDateView.setText(order.getProductpurchasedate());
        Glide.with(holder.mImageView.getContext()).load(order.getProductimage()).into(holder.mImageView);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyParcelable parcel = new MyParcelable(order.getProductname(), order.getProductprice(), order.getProductimage());
                Intent in = new Intent(view.getContext(), ProductDetailActivity.class);
                in.putExtra("myDataKey", parcel);
                view.getContext().startActivity(in);

            }
        });
    }
    @Override
    public int getItemCount() {
        return orderlist.size();
    }

}
