package com.example.infs3605_group_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.infs3605_group_project.R;

public class EtfDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etf_detail);

        Button btn = findViewById(R.id.buttonProjections);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Intent intent = new Intent(EtfDetail.this, ETFsLineChart.class);
                        EtfDetail.this.startActivity(intent);
            }
        });
    }
}
