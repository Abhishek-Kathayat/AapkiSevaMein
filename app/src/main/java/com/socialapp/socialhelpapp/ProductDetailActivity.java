package com.socialapp.socialhelpapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView productName;
    private TextView productPrice;
    private ImageView productImage;
    private CoordinatorLayout bottom_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        final Spinner spinner = (Spinner)findViewById(R.id.proddetail_Spinner);
        bottom_cart = (CoordinatorLayout)findViewById(R.id.Prodetail_Relay01);

        spinner.setOnItemSelectedListener(this);

        List<String> quantity = new ArrayList<String>();
        quantity.add("Kilograms (kg)");
        quantity.add("Grams (gm)");
        quantity.add("Litres (l)");
        quantity.add("Millilitres (ml)");
        quantity.add("Packet");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, quantity);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        productImage = findViewById(R.id.Prodetail_proimg);
        productName = findViewById(R.id.Prodetail_proname);
        productPrice = findViewById(R.id.Prodetail_proprice);

        MyParcelable parcelable = getIntent().getParcelableExtra("myDataKey");
        if(parcelable != null) {
            Glide.with(productImage.getContext()).load(parcelable.mthumb).into(productImage);
            productName.setText(parcelable.mName);
            productPrice.setText(parcelable.mPrice);
        }

        bottom_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startUserCart();
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: "+item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void startUserCart() {
        Intent in = new Intent(this.getApplicationContext(), MainActivity.class);
        in.putExtra("fragload", true);
        startActivity(in);
    }

}
