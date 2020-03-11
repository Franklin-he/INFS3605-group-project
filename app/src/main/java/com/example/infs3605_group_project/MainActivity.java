package com.example.infs3605_group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.incomeNext);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSpending();
            }
        });
    }
    public void toSpending(){
        Intent i = new Intent(this, Spending.class);
        EditText incomeInput = (EditText) findViewById(R.id.income);
        Double income = Double.valueOf(incomeInput.getText().toString());
        i.putExtra("income", income);
        startActivity(i);
    }
}
