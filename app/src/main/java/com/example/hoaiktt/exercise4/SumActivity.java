package com.example.hoaiktt.exercise4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SumActivity extends AppCompatActivity {
    private TextView mTvSum;
    private Button mBtnBack;
    private double mX ,
            mY , mSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);
        mTvSum = (TextView) findViewById(R.id.tvSum);
        mBtnBack = (Button) findViewById(R.id.btnBack);
        Bundle getInfoCaculator = getIntent().getExtras();
        if (getInfoCaculator != null) {
            mX = getInfoCaculator.getDouble("x");
            mY = getInfoCaculator.getDouble("y");
        }
        mSum = sum(mX, mY);
        mTvSum.setText(String.format(getResources().getString(R.string.txt_sum_activity), getDataRandomFromUri()));
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private double sum(double x, double y) {
        return x + y;
    }

    private double getDataRandomFromUri() {
        Uri mUri = getIntent().getData();
        if (mUri != null) {
            mX = getDoubleParam(mUri, "X");
            mY = getDoubleParam(mUri, "Y");
        }
        return (sum(mX, mY));
    }

    private double getDoubleParam(Uri uri, String queryParamName) {
        String rawValue = uri.getQueryParameter(queryParamName);
        double value = 0.0;
        try {
            value = Double.parseDouble(rawValue);
        } catch (NumberFormatException e) {
           e.printStackTrace();
        }
        return value;
    }
}
