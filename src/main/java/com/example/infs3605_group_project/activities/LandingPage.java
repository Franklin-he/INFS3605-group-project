package com.example.infs3605_group_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infs3605_group_project.R;

public class LandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo = findViewById(R.id.imageView);

        TextView logoFront = findViewById(R.id.titleFront);

        TextView mottoFront = findViewById(R.id.mottoFront);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPage.this, AddIncomeActivity.class);
                LandingPage.this.startActivity(intent);
            }

        });

        logo.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPage.this, AddIncomeActivity.class);
                LandingPage.this.startActivity(intent);
            }

        });

        logoFront.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPage.this, AddIncomeActivity.class);
                LandingPage.this.startActivity(intent);
            }

        });

        mottoFront.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPage.this, AddIncomeActivity.class);
                LandingPage.this.startActivity(intent);
            }

        });



    }
}
