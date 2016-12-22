package com.example.kunsang.ctm360wear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kunsang.ctm360wear.byseverity.BySeverityActivity;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initView();
    }

    private void initView() {
        findViewById(R.id.linearLayoutStatus).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linearLayoutStatus:
                Intent intent = new Intent(getApplicationContext(), BySeverityActivity.class);
                startActivity(intent);
                break;
        }
    }
}
