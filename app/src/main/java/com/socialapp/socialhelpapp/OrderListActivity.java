package com.socialapp.socialhelpapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.socialapp.socialhelpapp.Adapters.OrderAdapter;
import com.socialapp.socialhelpapp.Adapters.ProductAdapter;
import com.socialapp.socialhelpapp.Models.OrderList_Model;
import com.socialapp.socialhelpapp.Models.ProductList_Model;

import java.util.ArrayList;
import java.util.List;

public class OrderListActivity extends AppCompatActivity {
    private List<OrderList_Model> orderlist = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderslist);

        mRecyclerView = findViewById(R.id.order_view);
        mAdapter = new OrderAdapter(orderlist);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        prepareOrders();
    }

    private void prepareOrders() {
        OrderList_Model order = new OrderList_Model("Product_1", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00", "10kgs", "10/08/2018");
        orderlist.add(order);
        order = new OrderList_Model("Product_2", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00", "10kgs", "10/08/2018");
        orderlist.add(order);
        order = new OrderList_Model("Product_3", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00", "10kgs", "10/08/2018");
        orderlist.add(order);
        order = new OrderList_Model("Product_4", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00", "10kgs", "10/08/2018");
        orderlist.add(order);
        order = new OrderList_Model("Product_5", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00", "10kgs", "10/08/2018");
        orderlist.add(order);
        order = new OrderList_Model("Product_6", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00", "10kgs", "10/08/2018");
        orderlist.add(order);
        order = new OrderList_Model("Product_7", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00", "10kgs", "10/08/2018");
        orderlist.add(order);
        order = new OrderList_Model("Product_8", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00", "10kgs", "10/08/2018");
        orderlist.add(order);
        order = new OrderList_Model("Product_9", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00", "10kgs", "10/08/2018");
        orderlist.add(order);
        order = new OrderList_Model("Product_10", "http://www.ultimatesource.toys/wp-content/uploads/2013/11/dummy-image-landscape-1-1024x800.jpg", "Rs. 50.00", "10kgs", "10/08/2018");
        orderlist.add(order);
    }
}
