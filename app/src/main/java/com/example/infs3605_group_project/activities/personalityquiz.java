package com.example.infs3605_group_project.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.infs3605_group_project.R;
import com.google.gson.Gson;

import java.util.ArrayList;


import java.util.Properties;


public class personalityquiz extends AppCompatActivity {

    private ArrayList<QuestionnaireDataResult.APIProperties.Questions.Example> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalityquiz);

        TextView title = findViewById(R.id.title);
        title.setText("Question "+1);

        final double[] risk_score = {12};

        TextView option1 = findViewById(R.id.btnOption1);
        TextView option2 = findViewById(R.id.btnOption2);
        TextView option3 = findViewById(R.id.btnOption3);
        TextView option4 = findViewById(R.id.btnOption4);
        TextView option5 = findViewById(R.id.btnOption5);
        loadNewQuestion(0);

        final int[] counter = {1};
        option1.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(counter[0]<12 && counter[0]!=9)
                {
                    loadNewQuestion(counter[0]);
                    risk_score[0] = risk_score[0] + 2;
                } else if(counter[0]==9){
                    counter[0]++;
                }
                else{
                    Intent intent = new Intent(personalityquiz.this, ResultQuiz.class);
                    Bundle b = new Bundle();
                    b.putDouble("Risk", risk_score[0]);
                    intent.putExtras(b);
                    personalityquiz.this.startActivity(intent);
                }

                counter[0]++;
            }

        });
        option2.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(counter[0]<12 && counter[0]!=9)
                {
                    loadNewQuestion(counter[0]);
                    risk_score[0] = risk_score[0] + 1;
                } else if(counter[0]==9){
                    counter[0]++;
                }
                else{
                    Intent intent = new Intent(personalityquiz.this, ResultQuiz.class);
                    Bundle b = new Bundle();
                    b.putDouble("Risk", risk_score[0]);
                    intent.putExtras(b);
                    personalityquiz.this.startActivity(intent);
                }

                counter[0]++;
            }

        });
        option3.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(counter[0]<12 && counter[0]!=9)
                {
                    loadNewQuestion(counter[0]);
                } else if(counter[0]==9){
                    counter[0]++;
                }
                else{
                    Intent intent = new Intent(personalityquiz.this, ResultQuiz.class);
                    Bundle b = new Bundle();
                    b.putDouble("Risk", risk_score[0]);
                    intent.putExtras(b);
                    personalityquiz.this.startActivity(intent);
                }

                counter[0]++;
            }

        });
        option4.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(counter[0]<12 && counter[0]!=9)
                {
                    loadNewQuestion(counter[0]);
                    risk_score[0] = risk_score[0] - 1;
                } else if(counter[0]==9){
                    counter[0]++;
                }
                else{
                    Intent intent = new Intent(personalityquiz.this, ResultQuiz.class);
                    Bundle b = new Bundle();
                    b.putDouble("Risk", risk_score[0]);
                    intent.putExtras(b);
                    personalityquiz.this.startActivity(intent);
                }

                counter[0]++;
            }

        });
        option5.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                if(counter[0]<12 && counter[0]!=9)
                {
                    loadNewQuestion(counter[0]);
                    risk_score[0] = risk_score[0] - 2;
                } else if(counter[0]==9){
                    counter[0]++;
                }
                else{
                    Intent intent = new Intent(personalityquiz.this, ResultQuiz.class);
                    Bundle b = new Bundle();
                    b.putDouble("Risk", risk_score[0]);
                    intent.putExtras(b);
                    personalityquiz.this.startActivity(intent);
                }

                counter[0]++;
            }

        });


    }

    public void loadNewQuestion(final int counter)
    {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://api-store.evalueproduction.com/store/api-docs/EValue/RiskQuestionnaireProfiler/1.0.0";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final String apiResponse = response;
                PersonalityApiReponse personalityApiReponse = gson.fromJson(apiResponse,PersonalityApiReponse.class);
                //Parsing the String into UX
                TextView question = findViewById(R.id.tvQuestion);
                TextView option1 = findViewById(R.id.btnOption1);
                TextView option2 = findViewById(R.id.btnOption2);
                TextView option3 = findViewById(R.id.btnOption3);
                TextView option4 = findViewById(R.id.btnOption4);
                TextView  option5 = findViewById(R.id.btnOption5);
                TextView title = findViewById(R.id.title);



                //Setting values
                PersonalityApiReponse.Info infoObject = personalityApiReponse.getInfo();
                String des = infoObject.getDescription();
                QuestionnaireDataResult.APIProperties.Questions.Example exampleObject1 =
                        personalityApiReponse.getDefinitions().getQuestionnaireDataResult().getProperties().getQuestions().getExample().get(counter);

                ArrayList<QuestionnaireDataResult.APIProperties.Questions.Example.Responses> responsesArrayList = exampleObject1.getResponses();

                int questionCounter = counter +1;
                question.setText(exampleObject1.getQuestionText());
                option1.setText(responsesArrayList.get(0).getResponseText());
                option2.setText(responsesArrayList.get(1).getResponseText());
                option3.setText(responsesArrayList.get(2).getResponseText());
                option4.setText(responsesArrayList.get(3).getResponseText());
                option5.setText(responsesArrayList.get(4).getResponseText());

                if(questionCounter<=10)
                {title.setText("Question "+questionCounter+"/10");}
                else {
                    title.setText("Question "+10+"/10");
                }



                requestQueue.stop();
            }


        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(personalityquiz.this,"The request failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,responseListener,errorListener);

        requestQueue.add(stringRequest);

    }


}
