package com.example.hoaiktt.exercise4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtnGoToActivity1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mBtnGoToActivity1 = (Button) findViewById(R.id.btnGotoActivity1);
        mBtnGoToActivity1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnGotoActivity1){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}
