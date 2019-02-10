package com.socialapp.socialhelpapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;


public class CheckoutActivity extends AppCompatActivity implements PaymentResultListener {
    private Button btn_checkout;

    private static final String TAG = CheckoutActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Checkout.preload(getApplicationContext());

        Button button = (Button)findViewById(R.id.pay_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPayment();
            }
        });
    }

    public void startPayment() {

        Checkout checkout = new Checkout();
        final Activity activity = this;

        try {
            JSONObject options = new JSONObject();
            options.put("name", "Aapkisevamein");
            options.put("description", "Order ID : #1234");
            options.put("currency", "INR");
            options.put("amount", "1100.00");
            checkout.open(activity, options);
        }
        catch (Exception e) {
            Toast.makeText(activity, "Error in payment: "+ e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    @Override
    public void onPaymentSuccess(String razorpayPaymentID) {
        try {
            Toast.makeText(this, "Payment Successful: " + razorpayPaymentID, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e(TAG, "Exception in onPaymentSuccess", e);
        }
    }

    @SuppressWarnings("unused")
    @Override
    public void onPaymentError(int code, String response) {
        try {
            Toast.makeText(this, "Payment failed: " + code + " " + response, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e(TAG, "Exception in onPaymentError", e);
        }
    }
}
