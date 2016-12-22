package com.example.kunsang.ctm360wear.byseverity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.kunsang.ctm360wear.R;

public class BySeverityActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    Context context;
    TextView textViewCharts, textViewCounter;
    RadioButton radioButtonCharts, radioButtonCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_severity);
        context = this;
        initView();
        setupChartFragment();
    }

    private void initView() {
        textViewCharts = (TextView) findViewById(R.id.textViewChart);
        textViewCounter = (TextView) findViewById(R.id.textViewCounter);
        radioButtonCharts = (RadioButton) findViewById(R.id.radioCharts);
        radioButtonCounter = (RadioButton) findViewById(R.id.radioCounter);
        textViewCounter.setOnClickListener(this);
        textViewCharts.setOnClickListener(this);
        radioButtonCharts.setOnCheckedChangeListener(this);
        radioButtonCounter.setOnCheckedChangeListener(this);
    }

    private void replaceFragment(Fragment newFragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, newFragment, tag);
        transaction.commit();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textViewCounter:
                radioButtonCounter.performClick();
                break;
            case R.id.textViewChart:
                radioButtonCharts.performClick();
                break;

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.radioCharts:
                if (b) {
                    textViewCharts.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
                    textViewCharts.setTextColor(ContextCompat.getColor(context, R.color.white));
                    textViewCounter.setBackgroundColor(ContextCompat.getColor(context, R.color.tranparent));
                    textViewCounter.setTextColor(ContextCompat.getColor(context, R.color.grey));
                    setupChartFragment();
                } else {
                    textViewCounter.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
                    textViewCounter.setTextColor(ContextCompat.getColor(context, R.color.white));
                    textViewCharts.setBackgroundColor(ContextCompat.getColor(context, R.color.tranparent));
                    textViewCharts.setTextColor(ContextCompat.getColor(context, R.color.grey));
                    setupCouterFragment();
                }
                break;
            case R.id.radioCounter:
                if (b) {
                    textViewCounter.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
                    textViewCounter.setTextColor(ContextCompat.getColor(context, R.color.white));
                    textViewCharts.setBackgroundColor(ContextCompat.getColor(context, R.color.tranparent));
                    textViewCharts.setTextColor(ContextCompat.getColor(context, R.color.grey));
                    setupCouterFragment();

                } else {
                    textViewCharts.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
                    textViewCharts.setTextColor(ContextCompat.getColor(context, R.color.white));
                    textViewCounter.setBackgroundColor(ContextCompat.getColor(context, R.color.tranparent));
                    textViewCounter.setTextColor(ContextCompat.getColor(context, R.color.grey));
                    setupChartFragment();
                }
                break;
        }
    }

    public void setupChartFragment() {
        BarFragment dashboardFragment = new BarFragment();
        String tagName = dashboardFragment.getClass().getName();
        replaceFragment(dashboardFragment, tagName);
    }

    private void setupCouterFragment() {
        CircleFragment dashboardFragment = new CircleFragment();
        String tagName = dashboardFragment.getClass().getName();
        replaceFragment(dashboardFragment, tagName);
    }
}
