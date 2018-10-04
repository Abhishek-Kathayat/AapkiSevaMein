package com.socialapp.socialhelpapp.Adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.socialapp.socialhelpapp.Models.ProductList_Model;
import com.socialapp.socialhelpapp.Models.TollFreeList_Model;
import com.socialapp.socialhelpapp.MyParcelable;
import com.socialapp.socialhelpapp.ProductDetailActivity;
import com.socialapp.socialhelpapp.R;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class TollFreeAdapter extends RecyclerView.Adapter<TollFreeAdapter.TollFreeViewHolder> {

    private List<TollFreeList_Model> tfnumberlist;

    public static class TollFreeViewHolder extends RecyclerView.ViewHolder {
        public TextView mNameView;
        public TextView mNumberView;
        public Button callbutton;
        public TollFreeViewHolder(View view) {
            super(view);
            mNameView = view.findViewById(R.id.tollfreetext);
            mNumberView = view.findViewById(R.id.tollfreenumber);
        }
    }

    public TollFreeAdapter(List<TollFreeList_Model> tfnumberlist) {
        this.tfnumberlist = tfnumberlist;
    }

    @NonNull
    @Override
    public TollFreeAdapter.TollFreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View tollfreeview = LayoutInflater.from(parent.getContext()).inflate(R.layout.tollfreenumberbar, parent, false);
        return new TollFreeAdapter.TollFreeViewHolder(tollfreeview);
    }

    @Override
    public void onBindViewHolder(@NonNull TollFreeAdapter.TollFreeViewHolder holder, int position) {
        final TollFreeList_Model product = tfnumberlist.get(position);
        holder.mNameView.setText(product.getTollfreetextname());
        holder.mNumberView.setText(product.getTollfreenumber());
    }
    @Override
    public int getItemCount() {
        return tfnumberlist.size();
    }
}
