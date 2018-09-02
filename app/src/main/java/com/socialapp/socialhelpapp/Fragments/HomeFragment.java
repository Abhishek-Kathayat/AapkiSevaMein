package com.socialapp.socialhelpapp.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.socialapp.socialhelpapp.Adapters.HomeAdapter;
import com.socialapp.socialhelpapp.Models.ServiceList_Model;
import com.socialapp.socialhelpapp.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private List<ServiceList_Model> servicelist = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        mRecyclerView = view.findViewById(R.id.service_recycler_view);
        mAdapter = new HomeAdapter(servicelist);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        prepareServices();

        return view;
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
        service = new ServiceList_Model("Service9");
        servicelist.add(service);
    }
}
