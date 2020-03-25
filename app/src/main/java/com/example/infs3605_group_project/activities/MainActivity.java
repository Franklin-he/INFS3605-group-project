package com.example.infs3605_group_project.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.infs3605_group_project.IncomeViewModel;
import com.example.infs3605_group_project.R;
import com.example.infs3605_group_project.database.Income;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText editTotalIncome;
    private EditText editTotalSavings;

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

    }
}
