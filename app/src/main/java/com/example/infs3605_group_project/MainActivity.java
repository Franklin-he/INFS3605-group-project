package com.example.infs3605_group_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private IncomeViewModel incomeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incomeViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
        incomeViewModel.getAllIncomes().observe(this, new Observer<List<Income>>() {
            @Override
            public void onChanged(List<Income> incomes) {
                //update view
            }
        });

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
