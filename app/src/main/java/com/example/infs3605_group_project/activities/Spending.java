package com.example.infs3605_group_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.infs3605_group_project.R;

public class Spending extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending);

        Intent intent = getIntent();
        Double income = intent.getDoubleExtra("income",0);

        //TextView textView = (TextView) findViewById(R.id.incomeShow);
        //textView.setText("Your income" + income);

    }
}
