package com.example.infs3605_group_project.activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3605_group_project.R;

public class AddIncomeActivity extends AppCompatActivity {

    public static final String EXTRA_DESCRIPTION = "com.example.infs3605_group_project.R.EXTRA_DESCRIPTION";
    public static final String EXTRA_AMOUNT = "com.example.infs3605_group_project.R.EXTRA_AMOUNT";

    private EditText editIncomeDesc;
    private EditText editIncomeAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editIncomeDesc = findViewById(R.id.income_desc);
        editIncomeAmount = findViewById(R.id.income_amount);

        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Income");
    }

    public void saveIncome() {
        String desc = editIncomeDesc.getText().toString();
        Long amount = Long.valueOf(editIncomeAmount.getText().toString());

        if (desc.trim().isEmpty() || amount == null) {
            Toast.makeText(this, "Description and amount cannot be empty. ", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent incomes = new Intent();
        incomes.putExtra(EXTRA_DESCRIPTION, desc);
        incomes.putExtra(EXTRA_AMOUNT, amount);

        setResult(RESULT_OK, incomes);
        finish();

    }

}