package com.socialapp.socialhelpapp.Adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.socialapp.socialhelpapp.Models.ServiceList_Model;
import com.socialapp.socialhelpapp.R;
import com.socialapp.socialhelpapp.ServiceActivity;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<ServiceList_Model> servicelist;

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public RelativeLayout container;
        public MainViewHolder(View view) {
            super(view);
            mTextView = view.findViewById(R.id.service_name_main);
            container = view.findViewById(R.id.service_bar);
        }
    }

    public MainAdapter(List<ServiceList_Model> servicelist) {
        this.servicelist = servicelist;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View serviceview = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_bar, parent, false);
        return new MainViewHolder(serviceview);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        ServiceList_Model service = servicelist.get(position);
        holder.mTextView.setText(service.getServicename());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(view.getContext(), ServiceActivity.class);
                view.getContext().startActivity(in);
            }
        });
    }
    @Override
    public int getItemCount() {
        return servicelist.size();
    }
}
