package com.example.hoaiktt.exercise4;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class TabsActivity extends TabActivity{
    private TabHost  mTabShowSumActivity;
    private Drawable tabIcon;
    private static String mAddress = "sum://example.com/add";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_tabs);
        Resources res = getResources();
        mTabShowSumActivity = getTabHost();
        tabIcon = res.getDrawable(R.drawable.ic_caculator_normal );
        showTabOne();
        showTabTwo();
        showTabThree();
        showTab4();

    }

    public void showTabOne(){
        Intent mItent = new Intent(TabsActivity.this,SumActivity.class);
        TabHost.TabSpec mTabNoData = mTabShowSumActivity.newTabSpec("Tab one").setIndicator("Tab 1",tabIcon).setContent(mItent);
        mTabShowSumActivity.addTab(mTabNoData);
    }

    public void showTabTwo(){
        Intent mTab2 = new Intent(TabsActivity.this, SumActivity.class);
        Bundle mData = new Bundle();
        mData.putDouble("x", Math.random());
        mData.putDouble("y", Math.random());
        mTab2.putExtras(mData);
        TabHost.TabSpec mTabWithData = mTabShowSumActivity.newTabSpec("Tab Two").setIndicator("Tab 2",tabIcon).setContent(mTab2);
        mTabShowSumActivity.addTab(mTabWithData);
    }

   public void showTabThree(){
        Uri mUriSumActivity = Uri.parse(mAddress);
        Intent mTab3 = new Intent(Intent.ACTION_VIEW, mUriSumActivity);
        TabHost.TabSpec mTabNoData = mTabShowSumActivity.newTabSpec("Tab Three").setIndicator("Tab 3",tabIcon).setContent(mTab3);
        mTabShowSumActivity.addTab(mTabNoData);
    }

   public void showTab4(){
        Uri mUriSumActivity = Uri.parse(mAddress);
        Intent mTab4 = new Intent(Intent.ACTION_VIEW, mUriSumActivity);
        Bundle mData = new Bundle();
        mData.putDouble("x", Math.random());
        mData.putDouble("y", Math.random());
        mTab4.putExtras(mData);
        TabHost.TabSpec mTabWithData = mTabShowSumActivity.newTabSpec("Tab Fours").setIndicator("Tab 4",tabIcon).setContent(mTab4);
        mTabShowSumActivity.addTab(mTabWithData);
    }
}
