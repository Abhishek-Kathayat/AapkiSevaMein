package com.socialapp.socialhelpapp.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.socialapp.socialhelpapp.Adapters.HomeAdapter;
import com.socialapp.socialhelpapp.MainActivity;
import com.socialapp.socialhelpapp.Models.ServiceList_Model;
import com.socialapp.socialhelpapp.R;
import com.socialapp.socialhelpapp.rest.ApiClient;
import com.socialapp.socialhelpapp.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private List<ServiceList_Model> servicelist = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ProgressBar progressBar;

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
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new HomeAdapter(servicelist);
        mRecyclerView.setAdapter(mAdapter);
        progressBar = view.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        getServices();

        return view;
    }

    private void getServices() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<ServiceList_Model>> call = apiInterface.getServices();
        call.enqueue(new Callback<List<ServiceList_Model>>() {
            @Override
            public void onResponse(Call<List<ServiceList_Model>> call, Response<List<ServiceList_Model>> response) {
                List<ServiceList_Model> services = response.body();
                progressBar.setVisibility(View.GONE);
                HomeAdapter homeAdapter = new HomeAdapter(services);
                mRecyclerView.setAdapter(homeAdapter);
            }

            @Override
            public void onFailure(Call<List<ServiceList_Model>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
