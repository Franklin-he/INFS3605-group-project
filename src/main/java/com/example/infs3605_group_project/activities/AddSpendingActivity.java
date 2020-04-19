package com.example.infs3605_group_project.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3605_group_project.R;

public class AddSpendingActivity extends AppCompatActivity {

    EditText groceries_amount;
    EditText shopping_amount;
    EditText entertainment_amount;
    EditText utilities_amount;
    EditText transport_amount;
    EditText other_amount;
    Long groceries_amount_sp;
    Long shopping_amount_sp;
    Long entertainment_amount_sp;
    Long utilities_amount_sp;
    Long transport_amount_sp;
    Long other_amount_sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending);
        SharedPreferences spendings = getSharedPreferences("spendings", MODE_PRIVATE);

        groceries_amount = findViewById(R.id.groceries_amount);
        Long g_amount = spendings.getLong("groceries_amount_sp",0);
        groceries_amount.setText(g_amount.toString());

        shopping_amount = findViewById(R.id.shopping_amount);
        Long s_amount = spendings.getLong("shopping_amount_sp",0);
        shopping_amount.setText(s_amount.toString());

        entertainment_amount = findViewById(R.id.entertainment_amount);
        Long e_amount = spendings.getLong("entertainment_amount_sp",0);
        entertainment_amount.setText(e_amount.toString());

        utilities_amount = findViewById(R.id.utilities_amount);
        Long u_amount = spendings.getLong("utilities_amount_sp",0);
        utilities_amount.setText(u_amount.toString());

        transport_amount = findViewById(R.id.transport_amount);
        Long t_amount = spendings.getLong("transport_amount_sp",0);
        transport_amount.setText(t_amount.toString());

        other_amount = findViewById(R.id.other_amount);
        Long o_amount = spendings.getLong("other_amount_sp",0);
        other_amount.setText(o_amount.toString());



        TextView t_spendable = findViewById(R.id.total_spendable2);

        Intent intent = getIntent();
        Long total_spendable = intent.getLongExtra("total_spendable", 0);
        t_spendable.setText("$ " + total_spendable);

        Button spending_next = findViewById(R.id.spending_next);
        spending_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences spendings = getSharedPreferences("spendings", MODE_PRIVATE);
                SharedPreferences.Editor spending_editor = spendings.edit();

                if (!groceries_amount.getText().toString().isEmpty()){
                    groceries_amount_sp= Long.parseLong(groceries_amount.getText().toString());
                } else {
                    //groceries_amount.setError("Your groceries spending cannot by empty");
                    groceries_amount_sp = 0L;
                }

                if (!shopping_amount.getText().toString().isEmpty()){
                    shopping_amount_sp= Long.parseLong(shopping_amount.getText().toString());
                } else {
                    shopping_amount_sp = 0L;
                }

                if (!entertainment_amount.getText().toString().isEmpty()){
                    entertainment_amount_sp= Long.parseLong(entertainment_amount.getText().toString());
                } else {
                    entertainment_amount_sp = 0L;
                }

                if (!utilities_amount.getText().toString().isEmpty()){
                    utilities_amount_sp= Long.parseLong(utilities_amount.getText().toString());
                } else {
                    utilities_amount_sp = 0L;
                }

                if (!transport_amount.getText().toString().isEmpty()){
                    transport_amount_sp= Long.parseLong(transport_amount.getText().toString());
                } else {
                    transport_amount_sp = 0L;
                }

                if (!other_amount.getText().toString().isEmpty()){
                    other_amount_sp= Long.parseLong(other_amount.getText().toString());
                } else {
                    other_amount_sp = 0L;
                }
                Long monthly_total_spending = groceries_amount_sp + shopping_amount_sp + entertainment_amount_sp + utilities_amount_sp + transport_amount_sp + other_amount_sp;

                SharedPreferences incomes = getSharedPreferences("incomes", MODE_PRIVATE);
                Long t_savings = incomes.getLong("total_savings", 0);
                Long t_spendable = incomes.getLong("total_spendables", 0);


                if (monthly_total_spending > t_spendable) {
                    groceries_amount.setError("You spend more in a month than you have planned, cut back on your lifestyle or reduce your savings rate and risk retiring later than anticipated!");
                    shopping_amount.setError("");
                    entertainment_amount.setError("");
                    utilities_amount.setError("");
                    transport_amount.setError("");
                    other_amount.setError("");
                    return;
                    //error msg
                    /*Toast toast = Toast.makeText(this,R.string.spending_morethan_savings, Toast.LENGTH_LONG);
                    LinearLayout toastLayout = (LinearLayout) toast.getView();
                    TextView toastTV = (TextView) toastLayout.getChildAt(0);
                    toastTV.setTextSize(30);
                    toast.show();*/

                } else if (monthly_total_spending < t_spendable) {
                    //pop up msg
                    Toast toast = Toast.makeText(getApplicationContext(), "You spend $" + (t_spendable - monthly_total_spending) + " less in a month than you have planned, this amount is added to your savings. ", Toast.LENGTH_LONG);
                    LinearLayout toastLayout = (LinearLayout) toast.getView();
                    TextView toastTV = (TextView) toastLayout.getChildAt(0);
                    toastTV.setTextSize(30);
                    toast.show();

                    //change total savings, spendables
                    SharedPreferences.Editor income_editor = incomes.edit();
                    Long new_t_savings = t_savings + (t_spendable - monthly_total_spending);
                    income_editor.putLong("total_savings", new_t_savings);
                    Long new_t_spendable = (t_spendable - (t_spendable - monthly_total_spending));
                    income_editor.putLong("total_spendables", new_t_spendable);
                    income_editor.apply();

                    //store spendings
                    spending_editor.putLong("groceries_amount_sp", groceries_amount_sp);
                    spending_editor.putLong("shopping_amount_sp", shopping_amount_sp);
                    spending_editor.putLong("entertainment_amount_sp", entertainment_amount_sp);
                    spending_editor.putLong("utilities_amount_sp", utilities_amount_sp);
                    spending_editor.putLong("transport_amount_sp", transport_amount_sp);
                    spending_editor.putLong("other_amount_sp", other_amount_sp);
                    spending_editor.apply();
                } else if (monthly_total_spending == t_spendable) {
                    spending_editor.putLong("groceries_amount_sp", groceries_amount_sp);
                    spending_editor.putLong("shopping_amount_sp", shopping_amount_sp);
                    spending_editor.putLong("entertainment_amount_sp", entertainment_amount_sp);
                    spending_editor.putLong("utilities_amount_sp", utilities_amount_sp);
                    spending_editor.putLong("transport_amount_sp", transport_amount_sp);
                    spending_editor.putLong("other_amount_sp", other_amount_sp);
                    spending_editor.apply();
                    Toast.makeText(getApplicationContext(), "Spendings saved", Toast.LENGTH_SHORT).show();
                }


                Intent intent = new Intent(AddSpendingActivity.this, ShowRecommendInvestment.class);
                AddSpendingActivity.this.startActivity(intent);


            }
        });
    }


}
