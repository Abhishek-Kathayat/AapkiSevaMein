package com.socialapp.socialhelpapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.socialapp.socialhelpapp.Adapters.ProductAdapter;
import com.socialapp.socialhelpapp.Models.ProductList_Model;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {
    private List<ProductList_Model> productlist = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private CoordinatorLayout layout_cart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);

        mRecyclerView = findViewById(R.id.product_view);
        mAdapter = new ProductAdapter(productlist);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        layout_cart = (CoordinatorLayout)findViewById(R.id.bottomcart_products);

        layout_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUserCart();
            }
        });

        prepareProducts();
    }

    private void prepareProducts() {
        ProductList_Model product = new ProductList_Model("Product_1", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_2", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_3", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_4", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_5", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_6", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_7", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_8", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00");
        productlist.add(product);
    }

    private void showUserCart() {
        Intent in = new Intent(this.getApplicationContext(), MainActivity.class);
        in.putExtra("fragload", true);
        startActivity(in);
    }
}

