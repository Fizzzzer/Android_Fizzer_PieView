package com.fizzer.doraemon.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends Activity {

    private PieView mPieView;

    Integer[] dataList = new Integer[]{12,23,67,50};
    Integer[] colorList = new Integer[]{Color.parseColor("#FF0000"),
            Color.parseColor("#00FF00"),
            Color.parseColor("#0000FF"),
            Color.parseColor("#000000")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        mPieView = (PieView) findViewById(R.id.pieView);
        mPieView.setData(Arrays.asList(dataList));
        mPieView.setColorData(Arrays.asList(colorList));
    }
}
