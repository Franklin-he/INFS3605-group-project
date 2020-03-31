package com.example.infs3605_group_project.activities;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3605_group_project.R;
import com.example.infs3605_group_project.database.Income;
import com.example.infs3605_group_project.database.IncomeDao;
import com.example.infs3605_group_project.repository.IncomeRepository;

public class AddIncomeActivity extends AppCompatActivity {

    public static final String EXTRA_DESCRIPTION = "com.example.infs3605_group_project.R.EXTRA_DESCRIPTION";
    public static final String EXTRA_AMOUNT = "com.example.infs3605_group_project.R.EXTRA_AMOUNT";
    public static final int ADD_INCOME_REQUEST = 1;


    private EditText editTotalIncome;
    private EditText editSavingsRate;
    private IncomeRepository incomeRepository;

    private TextView total_income;
    private TextView total_savings;
    private TextView total_spendable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        editTotalIncome = findViewById(R.id.income_amount);
        editSavingsRate = findViewById(R.id.income_saving);

        //total_income = findViewById(R.id.total_income);
        //total_savings = findViewById(R.id.total_savings);
        //total_spendable = findViewById(R.id.total_spendable);

        SharedPreferences sharedPreferences = getSharedPreferences("incomes", MODE_PRIVATE);
        Long t_income = sharedPreferences.getLong("total_income", 0);
        Long savings_rate = sharedPreferences.getLong("savings_rate", 0);

        //editTotalIncome.setText(t_income.toString());
        //editSavingsRate.setText(savings_rate.toString());

        //incomeRepository = new IncomeRepository(getApplication());
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Income");

        Button button = findViewById(R.id.income_next);
        //store incomes
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveIncome();
                SharedPreferences sharedPreferences = getSharedPreferences("incomes", MODE_PRIVATE);
                Long t_spendable = sharedPreferences.getLong("total_spendables", 0);
                Intent intent = new Intent(AddIncomeActivity.this, AddSpendingActivity.class);
                intent.putExtra("total_spendable", t_spendable);
                AddIncomeActivity.this.startActivity(intent);
            }

        });

        /*
        Button show_income = findViewById(R.id.income_show);
        //show values
        show_income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("incomes", MODE_PRIVATE);
                Long t_income = sharedPreferences.getLong("total_income", 0);
                Long t_savings = sharedPreferences.getLong("total_savings", 0);
                Long t_spendable = sharedPreferences.getLong("total_spendables", 0);

                total_income.setText(t_income.toString());
                total_savings.setText(t_savings.toString());
                total_spendable.setText(t_spendable.toString());
            }

        });*/


    }

    /*public void saveIncome() {

        Long total_income = Long.valueOf(editTotalIncome.getText().toString());
        Long savings_rate = Long.valueOf(editSavingsRate.getText().toString());

        if (total_income == null || savings_rate == null) {
            Toast.makeText(this, "Description and amount cannot be empty. ", Toast.LENGTH_SHORT).show();
            return;
        }

        Long monthly_total_saving = total_income * (savings_rate/100);
        Long monthly_spendable_income = total_income - monthly_total_saving;

        Income income = new Income(total_income, monthly_total_saving, monthly_spendable_income);
        incomeRepository.insert(income);
    }*/

    public void saveIncome() {
        SharedPreferences sharedPreferences = getSharedPreferences("incomes", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (TextUtils.isEmpty(editTotalIncome.getText().toString())) {
            editTotalIncome.setError("Your total income cannot be empty");
            return;
        }
        if (TextUtils.isEmpty(editSavingsRate.getText().toString())) {
            editSavingsRate.setError("Your desired savings rate cannot be empty");
            return;
        }

        Long monthly_total_income = Long.parseLong(editTotalIncome.getText().toString());
        Long savings_rate = Long.valueOf(editSavingsRate.getText().toString());

        Long monthly_total_saving = ((monthly_total_income * savings_rate)/100);

        Long monthly_spendable_income = (monthly_total_income - monthly_total_saving);

        if (monthly_total_income == null || savings_rate == null) {
            Toast.makeText(this, "Total income and desired savings rate cannot be empty. ", Toast.LENGTH_SHORT).show();
            return;
        }
        editor.putLong("total_income", monthly_total_income);
        editor.putLong("savings_rate", savings_rate);
        editor.putLong("total_savings", monthly_total_saving);
        editor.putLong("total_spendables", monthly_spendable_income);

        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }


}