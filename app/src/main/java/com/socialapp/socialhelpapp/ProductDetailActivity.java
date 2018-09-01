package com.socialapp.socialhelpapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {
    private TextView productName;
    private TextView productPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        productName = (TextView)findViewById(R.id.Prodetail_proname);
        productPrice = (TextView)findViewById(R.id.Prodetail_proprice);

        MyParcelable parcelable = getIntent().getParcelableExtra("myDataKey");
        if(parcelable != null) {
            productName.setText(parcelable.mName);
            productPrice.setText(parcelable.mPrice);
        }

    }
}
