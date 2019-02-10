package com.socialapp.socialhelpapp.Fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.socialapp.socialhelpapp.Adapters.CartAdapter;
import com.socialapp.socialhelpapp.Adapters.HomeAdapter;
import com.socialapp.socialhelpapp.CheckoutActivity;
import com.socialapp.socialhelpapp.Models.CartList_Model;
import com.socialapp.socialhelpapp.Models.ServiceList_Model;
import com.socialapp.socialhelpapp.ProductListActivity;
import com.socialapp.socialhelpapp.R;

import java.util.ArrayList;
import java.util.List;

public class ShopCartFragment extends Fragment {
    public static List<CartList_Model> cartlist = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button products;
    private Button checkout;
    private TextView totalproducts;

    public ShopCartFragment() {
    }

    public static ShopCartFragment newInstance(String param1, String param2) {
        ShopCartFragment fragment = new ShopCartFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.shopcart, container, false);

        products = view.findViewById(R.id.scstatusbar_prodlist);
        checkout = view.findViewById(R.id.scstatusbar_checkout);
        mRecyclerView = view.findViewById(R.id.shopcartlist);
        totalproducts = view.findViewById(R.id.scstatusbar_totalitemamt);
        mAdapter = new CartAdapter(cartlist);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showproducts();
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkout();
            }
        });

        totalproducts.setText(Integer.toString(cartlist.size()));

        return view;
    }

    private void showproducts() {
        Intent in = new Intent(this.getContext(), ProductListActivity.class);
        startActivity(in);
    }
    private void checkout() {
        Intent in = new Intent(this.getContext(), CheckoutActivity.class);
        startActivity(in);
    }
}
