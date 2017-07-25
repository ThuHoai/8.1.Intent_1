package com.example.hoaiktt.exercise4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnGoToSecondActivity, mBtnGotoSumActivity, mBtnCaculator, mBtnShowTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnGoToSecondActivity = (Button) findViewById(R.id.btnGotoActivity2);
        mBtnGotoSumActivity = (Button) findViewById(R.id.btnGotoSumActivity);
        mBtnCaculator = (Button) findViewById(R.id.btnCaculator);
        mBtnShowTab = (Button) findViewById(R.id.btnTabs);
        mBtnShowTab.setOnClickListener(this);
        mBtnGoToSecondActivity.setOnClickListener(this);
        mBtnGotoSumActivity.setOnClickListener(this);
        mBtnCaculator.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGotoActivity2: {
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.btnGotoSumActivity: {
                Intent mIntent1 = new Intent(this, SumActivity.class);
                startActivity(mIntent1);
            }
            break;
            case R.id.btnCaculator: {
                Intent mIntent2 = new Intent(this, SumActivity.class);
                Bundle mInfoCaculator = new Bundle();
                mInfoCaculator.putDouble("x", Math.random());
                mInfoCaculator.putDouble("y", Math.random());
                mIntent2.putExtras(mInfoCaculator);
                startActivity(mIntent2);
            }
            break;
            case R.id.btnTabs: {
                Intent mItentTab = new Intent(this, TabsActivity.class);
                startActivity(mItentTab);
            }
            default: {
                //no donothing;
            }
            break;
        }
    }
}
