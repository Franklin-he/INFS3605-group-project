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
import com.example.infs3605_group_project.entities.Income;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_NOTE_REQUEST = 1;

    private EditText editIncomeDesc;
    private EditText editIncomeAmount;

    private IncomeViewModel incomeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editIncomeDesc = findViewById(R.id.income_desc);
        editIncomeAmount = findViewById(R.id.income_amount);


        incomeViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
        incomeViewModel.getAllIncomes().observe(this, new Observer<List<Income>>() {
            @Override
            public void onChanged(List<Income> incomes) {
                //update view
            }
        });

        Button button = findViewById(R.id.income_calculate);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toSpending();
                Intent intent = new Intent(MainActivity.this, AddIncomeActivity.class);
                startActivityForResult(intent, ADD_NOTE_REQUEST);
            }

        });
    }

    public void toSpending(){
        Intent i = new Intent(this, Spending.class);
        EditText incomeInput = (EditText) findViewById(R.id.income_amount);
        Double income = Double.valueOf(incomeInput.getText().toString());
        i.putExtra("income", income);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTE_REQUEST && resultCode == RESULT_OK) {
            String desc = data.getStringExtra(AddIncomeActivity.EXTRA_DESCRIPTION);
            Long amount = data.getLongExtra(AddIncomeActivity.EXTRA_AMOUNT, 0);

            Income income = new Income(desc, amount);
            incomeViewModel.insert(income);

            Toast.makeText(this, "Income saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Income not saved", Toast.LENGTH_SHORT).show();
        }
    }
}
