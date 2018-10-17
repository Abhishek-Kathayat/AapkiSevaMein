package com.socialapp.socialhelpapp.Fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.socialapp.socialhelpapp.FeedbackActivity;
import com.socialapp.socialhelpapp.OrderListActivity;
import com.socialapp.socialhelpapp.R;

public class AccountFragment extends Fragment{
    public Button feedbackbutton;
    public Button orders;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.account, container, false);

        feedbackbutton = view.findViewById(R.id.account_feedback);
        orders = view.findViewById(R.id.account_orders);

        feedbackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startfeedbackActivity();
            }
        });

        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showoldorders();
            }
        });

        return view;
    }

    public void startfeedbackActivity() {
        Intent in = new Intent(this.getContext(), FeedbackActivity.class);
        startActivity(in);
    }

    public void showoldorders() {
        Intent in = new Intent(this.getContext(), OrderListActivity.class);
        startActivity(in);
    }
}
