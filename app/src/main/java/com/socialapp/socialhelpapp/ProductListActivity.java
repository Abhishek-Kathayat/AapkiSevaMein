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

public class ProductListActivity extends AppCompatActivity {
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
        ProductList_Model product = new ProductList_Model("Product_1", "https://images.yourstory.com/2016/08/125-fall-in-love.png", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_2", "https://images.yourstory.com/2016/08/125-fall-in-love.png", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_3", "https://images.yourstory.com/2016/08/125-fall-in-love.png", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_4", "https://images.yourstory.com/2016/08/125-fall-in-love.png", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_5", "https://images.yourstory.com/2016/08/125-fall-in-love.png", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_6", "https://images.yourstory.com/2016/08/125-fall-in-love.png", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_7", "https://images.yourstory.com/2016/08/125-fall-in-love.png", "Rs. 50.00");
        productlist.add(product);
        product = new ProductList_Model("Product_8", "https://images.yourstory.com/2016/08/125-fall-in-love.png", "Rs. 50.00");
        productlist.add(product);
    }
}
