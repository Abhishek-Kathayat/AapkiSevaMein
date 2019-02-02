package com.socialapp.socialhelpapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.socialapp.socialhelpapp.Adapters.ProductAdapter;
import com.socialapp.socialhelpapp.Models.ProductList_Model;
import com.socialapp.socialhelpapp.Models.ServiceList_Model;
import com.socialapp.socialhelpapp.rest.ApiClient;
import com.socialapp.socialhelpapp.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListActivity extends AppCompatActivity {
    private List<ProductList_Model> productlist = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private CoordinatorLayout layout_cart;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);

        mRecyclerView = findViewById(R.id.product_view);
        progressBar = findViewById(R.id.progress_bar_products);
        progressBar.setVisibility(View.VISIBLE);
        mAdapter = new ProductAdapter(productlist);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        layout_cart = (CoordinatorLayout)findViewById(R.id.bottomcart_products);

        getProducts();

        layout_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUserCart();
            }
        });
    }

    private void getProducts() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<ProductList_Model>> call = apiInterface.getProducts();
        call.enqueue(new Callback<List<ProductList_Model>>() {
            @Override
            public void onResponse(Call<List<ProductList_Model>> call, Response<List<ProductList_Model>> response) {
                List<ProductList_Model> products = response.body();
                progressBar.setVisibility(View.GONE);
                ProductAdapter productAdapter = new ProductAdapter(products);
                mRecyclerView.setAdapter(productAdapter);
            }

            @Override
            public void onFailure(Call<List<ProductList_Model>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    private void showUserCart() {
        Intent in = new Intent(this.getApplicationContext(), MainActivity.class);
        in.putExtra("fragload", true);
        startActivity(in);
    }
}

