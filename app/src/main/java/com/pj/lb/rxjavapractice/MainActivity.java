package com.pj.lb.rxjavapractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @className: MainActivity
 * @classDescription:  main page
 * @author: leibing
 * @createTime:
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // onclick
        findViewById(R.id.btn_simple_rx).setOnClickListener(this);
        findViewById(R.id.btn_rx_map).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_simple_rx:
                // simple rxjava do
                RxjavaPractice.simpleRxDo();
                break;
            case R.id.btn_rx_map:
                // rx map do
                RxjavaPractice.rxMapDo();
                break;
            default:
                break;
        }
    }
}
