package com.example.infs3605_group_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

import java.util.Properties;

public class personalityquiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalityquiz);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://api-store.evalueproduction.com/store/api-docs/EValue/RiskQuestionnaireProfiler/1.0.0";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                PersonalityApiReponse personalityApiReponse = gson.fromJson(response,PersonalityApiReponse.class);
                //Parsing the String into UX
                TextView question = findViewById(R.id.questiontxtV);
                TextView question1 = findViewById(R.id.questiontxtV1);
                TextView question2 = findViewById(R.id.questiontxtV2);
                TextView question3 = findViewById(R.id.questiontxtV3);
                TextView question4 = findViewById(R.id.questiontxtV4);
                TextView question5 = findViewById(R.id.questiontxtV5);
                //Setting values
                PersonalityApiReponse.Definitions.QuestionnaireDataResult question_object =
                        personalityApiReponse.getDefinitions().getQuestionnaireDataResult();

                PersonalityApiReponse.Definitions.QuestionnaireDataResult.Properties properties = question_object.getProperties();

                PersonalityApiReponse.Definitions.QuestionnaireDataResult.Properties.Questions api_question_object = properties.getQuestions();

                PersonalityApiReponse.Definitions.QuestionnaireDataResult.Properties.Questions.Example [] examples = api_question_object.getExample();

                PersonalityApiReponse.Definitions.QuestionnaireDataResult.Properties.Questions.Example example1 = examples[0];


                question.setText(example1.getQuestionText());
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
