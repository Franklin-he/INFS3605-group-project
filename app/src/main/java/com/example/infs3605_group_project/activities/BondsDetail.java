package com.example.infs3605_group_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.infs3605_group_project.R;

public class BondsDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonds_detail);

        Button buttonBonds = findViewById(R.id.btnProjections);

        buttonBonds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BondsDetail.this, BondsLineChart.class);
                BondsDetail.this.startActivity(intent);
            }
        });
    }
}
