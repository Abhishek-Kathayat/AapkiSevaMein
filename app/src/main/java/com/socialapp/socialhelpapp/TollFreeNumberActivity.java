package com.socialapp.socialhelpapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.socialapp.socialhelpapp.Adapters.TollFreeAdapter;
import com.socialapp.socialhelpapp.Models.TollFreeList_Model;

import java.util.ArrayList;
import java.util.List;

public class TollFreeNumberActivity extends AppCompatActivity {
    private List<TollFreeList_Model> tollFreeList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tollfreenumberlist);

        mRecyclerView = findViewById(R.id.tollfree_view);
        mAdapter = new TollFreeAdapter(tollFreeList);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        preparetfnumbers();
    }

    private void preparetfnumbers() {
        TollFreeList_Model tfnumber = new TollFreeList_Model("Toll-Free Number 1", "1800 180 100");
        tollFreeList.add(tfnumber);
        tfnumber = new TollFreeList_Model("Toll-Free Number 2", "1800 180 101");
        tollFreeList.add(tfnumber);
        tfnumber = new TollFreeList_Model("Toll-Free Number 3", "1800 180 102");
        tollFreeList.add(tfnumber);
        tfnumber = new TollFreeList_Model("Toll-Free Number 4", "1800 180 103");
        tollFreeList.add(tfnumber);
        tfnumber = new TollFreeList_Model("Toll-Free Number 5", "1800 180 104");
        tollFreeList.add(tfnumber);
        tfnumber = new TollFreeList_Model("Toll-Free Number 6", "1800 180 105");
        tollFreeList.add(tfnumber);
        tfnumber = new TollFreeList_Model("Toll-Free Number 7", "1800 180 106");
        tollFreeList.add(tfnumber);
        tfnumber = new TollFreeList_Model("Toll-Free Number 8", "1800 180 107");
        tollFreeList.add(tfnumber);
    }
}
