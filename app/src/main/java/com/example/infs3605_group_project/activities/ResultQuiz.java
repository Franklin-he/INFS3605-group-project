package com.example.infs3605_group_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.infs3605_group_project.R;

public class ResultQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quiz);

        Bundle b = getIntent().getExtras();
        double risk_rating = b.getDouble("Risk");

        TextView tvScore = findViewById(R.id.tvScore);
        tvScore.setText("Score "+ risk_rating);
        Button btnInvestment = findViewById(R.id.btnInvestment);
        TextView tvInvestment = findViewById(R.id.tvInvestment);
        if(risk_rating<7)
        {
            tvInvestment.setText( "We have determined that a low risk, low return strategy is optimal for your investments in Bonds");
            btnInvestment.setText("Bonds");
        }else if(risk_rating>18){
            tvInvestment.setText( "We have determined that a high risk, high return strategy is optimal for your investments in Stocks");
            btnInvestment.setText("Stocks");
        }else{
            tvInvestment.setText( "We have determined that a moderate risk, moderate return strategy is optimal for your investments in ETFs");
            btnInvestment.setText("ETFs");

        }

        Button btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ResultQuiz.this, ShowRecommendInvestment.class);
                ResultQuiz.this.startActivity(intent);



            }

        });

    }
}
