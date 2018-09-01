package com.socialapp.socialhelpapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ProductDetailActivity extends AppCompatActivity {
    private TextView productName;
    private TextView productPrice;
    private ImageView productImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        productImage = findViewById(R.id.Prodetail_proimg);
        productName = findViewById(R.id.Prodetail_proname);
        productPrice = findViewById(R.id.Prodetail_proprice);

        MyParcelable parcelable = getIntent().getParcelableExtra("myDataKey");
        if(parcelable != null) {
            Glide.with(productImage.getContext()).load(parcelable.mthumb).into(productImage);
            productName.setText(parcelable.mName);
            productPrice.setText(parcelable.mPrice);
        }
    }
}
