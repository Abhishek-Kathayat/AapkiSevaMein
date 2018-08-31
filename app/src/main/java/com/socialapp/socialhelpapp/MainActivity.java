package com.socialapp.socialhelpapp;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.socialapp.socialhelpapp.Adapters.MainAdapter;
import com.socialapp.socialhelpapp.Models.ServiceList_Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ServiceList_Model> servicelist = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.service_view);
        mAdapter = new MainAdapter(servicelist);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        prepareServices();
    }

    private void prepareServices() {
        ServiceList_Model service = new ServiceList_Model("Service1");
        servicelist.add(service);
        service = new ServiceList_Model("Service2");
        servicelist.add(service);
        service = new ServiceList_Model("Service3");
        servicelist.add(service);
        service = new ServiceList_Model("Service4");
        servicelist.add(service);
        service = new ServiceList_Model("Service5");
        servicelist.add(service);
        service = new ServiceList_Model("Service6");
        servicelist.add(service);
        service = new ServiceList_Model("Service7");
        servicelist.add(service);
        service = new ServiceList_Model("Service8");
        servicelist.add(service);
    }
}
