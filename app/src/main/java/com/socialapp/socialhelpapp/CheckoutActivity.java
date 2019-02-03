package com.socialapp.socialhelpapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class CheckoutActivity extends AppCompatActivity {
    private Button btn_checkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        btn_checkout = findViewById(R.id.button14);
        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), checkoutAddress.class);
                startActivity(in);
            }
        });
    }
}
