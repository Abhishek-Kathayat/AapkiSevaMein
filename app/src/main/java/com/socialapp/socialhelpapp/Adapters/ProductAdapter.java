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
import com.socialapp.socialhelpapp.Models.ProductList_Model;
import com.socialapp.socialhelpapp.MyParcelable;
import com.socialapp.socialhelpapp.ProductDetailActivity;
import com.socialapp.socialhelpapp.R;
import com.socialapp.socialhelpapp.ServiceActivity;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<ProductList_Model> productlist;

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView mNameView, mPriceView;
        public ImageView mImageView;
        public CoordinatorLayout container;
        public ProductViewHolder(View view) {
            super(view);
            mNameView = view.findViewById(R.id.Text_ProductBar);
            mPriceView = view.findViewById(R.id.Price_ProductBar);
            mImageView = view.findViewById(R.id.Image_ProductBar);
            container = view.findViewById(R.id.product_bar);
        }
    }

    public ProductAdapter(List<ProductList_Model> productlist) {
        this.productlist = productlist;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View productview = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_bar, parent, false);
        return new ProductAdapter.ProductViewHolder(productview);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        ProductList_Model product = productlist.get(position);
        holder.mNameView.setText(product.getProductname());
        holder.mPriceView.setText(product.getProductprice());
        Glide.with(holder.mImageView.getContext()).load(product.getProductimage()).into(holder.mImageView);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyParcelable parcel = new MyParcelable();
                Intent in = new Intent(view.getContext(), ProductDetailActivity.class);
                in.putExtra("myDataKey", parcel);
                view.getContext().startActivity(in);
            }
        });
    }
    @Override
    public int getItemCount() {
        return productlist.size();
    }
}
