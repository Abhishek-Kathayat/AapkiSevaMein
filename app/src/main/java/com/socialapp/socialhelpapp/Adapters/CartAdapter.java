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
import com.socialapp.socialhelpapp.Models.CartList_Model;
import com.socialapp.socialhelpapp.Models.ProductList_Model;
import com.socialapp.socialhelpapp.MyParcelable;
import com.socialapp.socialhelpapp.ProductDetailActivity;
import com.socialapp.socialhelpapp.R;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<CartList_Model> cartlist;

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        public TextView mNameView, mPriceView, mQuantityView;
        public ImageView mImageView;
        public CoordinatorLayout container;
        public CartViewHolder(View view) {
            super(view);
            mNameView = view.findViewById(R.id.scprodbar_prodname);
            mPriceView = view.findViewById(R.id.scprodbar_prodprice);
            mQuantityView = view.findViewById(R.id.scprodbar_prodquantity);
            mImageView = view.findViewById(R.id.scprodbar_prodimage);
            container = view.findViewById(R.id.shopcartproductbar);
        }
    }

    public CartAdapter(List<CartList_Model> cartlist) {
        this.cartlist = cartlist;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View cartview = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopcartproductbar, parent, false);
        return new CartAdapter.CartViewHolder(cartview);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        final CartList_Model cart = cartlist.get(position);
        holder.mNameView.setText(cart.getProductname());
        holder.mPriceView.setText(cart.getProductprice());
        holder.mQuantityView.setText(cart.getProductquantity());
        Glide.with(holder.mImageView.getContext()).load(cart.getProductimage()).into(holder.mImageView);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyParcelable parcel = new MyParcelable(cart.getProductname(), cart.getProductprice(), cart.getProductimage());
                Intent in = new Intent(view.getContext(), ProductDetailActivity.class);
                in.putExtra("myDataKey", parcel);
                view.getContext().startActivity(in);

            }
        });
    }
    @Override
    public int getItemCount() {
        return cartlist.size();
    }

}
