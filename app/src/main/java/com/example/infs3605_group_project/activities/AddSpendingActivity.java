package com.example.infs3605_group_project.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3605_group_project.R;

public class AddSpendingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending);
        TextView t_spendable = findViewById(R.id.total_spendable2);

        Intent intent = getIntent();
        Long total_spendable = intent.getLongExtra("total_spendable", 0);
        t_spendable.setText("$ " + total_spendable);

        Button spending_next = findViewById(R.id.spending_next);
        spending_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSpendingActivity.this, ShowRecommendInvestment.class);
                AddSpendingActivity.this.startActivity(intent);
            }
        });
    }

}
