package com.socialapp.socialhelpapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.socialapp.socialhelpapp.Adapters.ProductAdapter;
import com.socialapp.socialhelpapp.Models.ProductList_Model;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    private List<ProductList_Model> productlist = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);

        mRecyclerView = (RecyclerView)findViewById(R.id.product_view);
        mAdapter = new ProductAdapter(productlist);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        prepareProducts();
    }

    private void prepareProducts() {

    }
}
