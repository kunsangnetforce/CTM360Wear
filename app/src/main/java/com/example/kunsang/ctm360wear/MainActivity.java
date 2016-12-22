package com.example.kunsang.ctm360wear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity implements View.OnClickListener {

    private Timer timer;
    TextView textViewDay, textViewDate, textViewTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setFormatedTime();
        setTime();

    }

    private void initView() {
        findViewById(R.id.buttonSubmit).setOnClickListener(this);
        textViewDay = (TextView) findViewById(R.id.textViewDay);
        textViewDate = (TextView) findViewById(R.id.textViewDate);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
    }

    private void setTime() {
        final Handler ha = new Handler();
        ha.postDelayed(new Runnable() {

            @Override
            public void run() {
                //call function
                setFormatedTime();
                ha.postDelayed(this, 30000);
            }
        }, 10000);
    }

    private void setFormatedTime() {
        long date = System.currentTimeMillis();
        textViewDay.setText(getFormattedDay(date));
        textViewDate.setText(getFormattedDate(date));
        textViewTime.setText(getFormattedTime(date));

    }

    private String getFormattedTime(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        String time = sdf.format(date);
        return time;

    }

    private String getFormattedDate(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        String day = sdf.format(date);
        return day;
    }

    private String getFormattedDay(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE");
        String day = sdf.format(date);
        return day;
    }

    @Override
    protected void onPause() {
        try {
            timer.cancel();
        } catch (Exception ex) {

        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        try {
            timer.cancel();
        } catch (Exception ex) {

        }
        super.onDestroy();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSubmit:
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
                break;
        }
    }
}
