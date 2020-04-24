package com.example.infs3605_group_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
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

public class SectorPerformance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_performance);
        RealTimeloadSectorPerformance();
        Button realbtn = findViewById(R.id.realbtn);
        Button day1btn = findViewById(R.id.day1btn);
        Button day5btn = findViewById(R.id.day5btn);
        Button month1btn = findViewById(R.id.month1btn);
        Button month3btn = findViewById(R.id.month3btn);
        Button ytdbtn = findViewById(R.id.ytdbtn);
        Button year3btn = findViewById(R.id.year3btn);
        Button year5btn = findViewById(R.id.year5btn);
        Button year10btn = findViewById(R.id.year10btn);


        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://www.alphavantage.co/query?function=SECTOR&apikey=27IHIPCVCKBHRMXF";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final String apiResponse = response;
                SectorPerformanceAPI sectorApiReponse = gson.fromJson(apiResponse,SectorPerformanceAPI.class);
                SectorPerformanceAPI.MetaData metaData =sectorApiReponse.getMetaData();

                TextView title = findViewById(R.id.sector_title);
                TextView date = findViewById(R.id.date);

                title.setText(metaData.getInformation());
                date.setText(metaData.getLastRefreshed());


                requestQueue.stop();
            }


        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SectorPerformance.this,"The request failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,responseListener,errorListener);

        requestQueue.add(stringRequest);

        realbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RealTimeloadSectorPerformance();
                Toast toast = Toast.makeText(SectorPerformance.this, "Max 5 requests per min!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        day1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day1loadSectorPerformance();
                Toast toast = Toast.makeText(SectorPerformance.this, "Max 5 requests per min!", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        day5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Day5loadSectorPerformance();
                Toast toast = Toast.makeText(SectorPerformance.this, "Max 5 requests per min!", Toast.LENGTH_LONG);
                toast.show();
            }
        }); month1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Month1loadSectorPerformance();
                Toast toast = Toast.makeText(SectorPerformance.this, "Max 5 requests per min!", Toast.LENGTH_LONG);
                toast.show();
            }
        }); month3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Month3loadSectorPerformance();
                Toast toast = Toast.makeText(SectorPerformance.this, "Max 5 requests per min!", Toast.LENGTH_LONG);
                toast.show();
            }
        }); ytdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YTDloadSectorPerformance();
                Toast toast = Toast.makeText(SectorPerformance.this, "Max 5 requests per min!", Toast.LENGTH_LONG);
                toast.show();
            }
        }); year3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Year3loadSectorPerformance();
                Toast toast = Toast.makeText(SectorPerformance.this, "Max 5 requests per min!", Toast.LENGTH_LONG);
                toast.show();
            }
        }); year5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Year5loadSectorPerformance();
                Toast toast = Toast.makeText(SectorPerformance.this, "Max 5 requests per min!", Toast.LENGTH_LONG);
                toast.show();
            }
        }); year10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Year10loadSectorPerformance();
                Toast toast = Toast.makeText(SectorPerformance.this, "Max 5 requests per min!", Toast.LENGTH_LONG);
                toast.show();
            }
        });





    }
    public void RealTimeloadSectorPerformance()
    {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://www.alphavantage.co/query?function=SECTOR&apikey=27IHIPCVCKBHRMXF";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final String apiResponse = response;
                SectorPerformanceAPI sectorApiReponse = gson.fromJson(apiResponse,SectorPerformanceAPI.class);



                TextView itValue = findViewById(R.id.itValue);
                TextView energyValue = findViewById(R.id.energyValue);
                TextView utilValue = findViewById(R.id.utilValue);
                TextView commValue = findViewById(R.id.commValue);
                TextView matValue = findViewById(R.id.matValue);
                TextView consumValue = findViewById(R.id.consumValue);
                TextView estateValue = findViewById(R.id.estateValue);
                TextView healthValue = findViewById(R.id.healthValue);
                TextView industValue = findViewById(R.id.industrialValue);



                SectorPerformanceAPI.RealTime realTime = sectorApiReponse.getReal_Time_PerformanceaData();

                itValue.setText(realTime.getInformationTech());
                energyValue.setText(realTime.getEnergy());
                utilValue.setText(realTime.getUtilities());
                commValue.setText(realTime.getCommServices());
                matValue.setText(realTime.getMaterials());
                consumValue.setText(realTime.getConsumerDis());
                estateValue.setText(realTime.getRealestate());
                healthValue.setText(realTime.getHealthcare());
                industValue.setText(realTime.getIndustrials());

                requestQueue.stop();
            }


        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SectorPerformance.this,"The request failed: " + error.getMessage(),
                        Toast.LENGTH_LONG).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,responseListener,errorListener);

        requestQueue.add(stringRequest);
    }
    public void Day1loadSectorPerformance()
    {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://www.alphavantage.co/query?function=SECTOR&apikey=27IHIPCVCKBHRMXF";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final String apiResponse = response;
                SectorPerformanceAPI sectorApiReponse = gson.fromJson(apiResponse,SectorPerformanceAPI.class);



                TextView itValue = findViewById(R.id.itValue);
                TextView energyValue = findViewById(R.id.energyValue);
                TextView utilValue = findViewById(R.id.utilValue);
                TextView commValue = findViewById(R.id.commValue);
                TextView matValue = findViewById(R.id.matValue);
                TextView consumValue = findViewById(R.id.consumValue);
                TextView estateValue = findViewById(R.id.estateValue);
                TextView healthValue = findViewById(R.id.healthValue);
                TextView industValue = findViewById(R.id.industrialValue);



                SectorPerformanceAPI.Day1 day1 = sectorApiReponse.getDay1();

                itValue.setText(day1.getInformationTech());
                energyValue.setText(day1.getEnergy());
                utilValue.setText(day1.getUtilities());
                commValue.setText(day1.getCommServices());
                matValue.setText(day1.getMaterials());
                consumValue.setText(day1.getConsumerDis());
                estateValue.setText(day1.getRealestate());
                healthValue.setText(day1.getHealthcare());
                industValue.setText(day1.getIndustrials());

                requestQueue.stop();
            }


        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SectorPerformance.this,"The request failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,responseListener,errorListener);

        requestQueue.add(stringRequest);
    }
    public void Day5loadSectorPerformance()
    {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://www.alphavantage.co/query?function=SECTOR&apikey=27IHIPCVCKBHRMXF";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final String apiResponse = response;
                SectorPerformanceAPI sectorApiReponse = gson.fromJson(apiResponse,SectorPerformanceAPI.class);




                TextView itValue = findViewById(R.id.itValue);
                TextView energyValue = findViewById(R.id.energyValue);
                TextView utilValue = findViewById(R.id.utilValue);
                TextView commValue = findViewById(R.id.commValue);
                TextView matValue = findViewById(R.id.matValue);
                TextView consumValue = findViewById(R.id.consumValue);
                TextView estateValue = findViewById(R.id.estateValue);
                TextView healthValue = findViewById(R.id.healthValue);
                TextView industValue = findViewById(R.id.industrialValue);


                SectorPerformanceAPI.Day5 day5 = sectorApiReponse.getDay5();

                itValue.setText(day5.getInformationTech());
                energyValue.setText(day5.getEnergy());
                utilValue.setText(day5.getUtilities());
                commValue.setText(day5.getCommServices());
                matValue.setText(day5.getMaterials());
                consumValue.setText(day5.getConsumerDis());
                estateValue.setText(day5.getRealestate());
                healthValue.setText(day5.getHealthcare());
                industValue.setText(day5.getIndustrials());

                requestQueue.stop();
            }


        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SectorPerformance.this,"The request failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,responseListener,errorListener);

        requestQueue.add(stringRequest);
    }

    public void Month1loadSectorPerformance()
    {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://www.alphavantage.co/query?function=SECTOR&apikey=27IHIPCVCKBHRMXF";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final String apiResponse = response;
                SectorPerformanceAPI sectorApiReponse = gson.fromJson(apiResponse,SectorPerformanceAPI.class);




                TextView itValue = findViewById(R.id.itValue);
                TextView energyValue = findViewById(R.id.energyValue);
                TextView utilValue = findViewById(R.id.utilValue);
                TextView commValue = findViewById(R.id.commValue);
                TextView matValue = findViewById(R.id.matValue);
                TextView consumValue = findViewById(R.id.consumValue);
                TextView estateValue = findViewById(R.id.estateValue);
                TextView healthValue = findViewById(R.id.healthValue);
                TextView industValue = findViewById(R.id.industrialValue);


                SectorPerformanceAPI.Month1 month1 = sectorApiReponse.getMonth1();

                itValue.setText(month1.getInformationTech());
                energyValue.setText(month1.getEnergy());
                utilValue.setText(month1.getUtilities());
                commValue.setText(month1.getCommServices());
                matValue.setText(month1.getMaterials());
                consumValue.setText(month1.getConsumerDis());
                estateValue.setText(month1.getRealestate());
                healthValue.setText(month1.getHealthcare());
                industValue.setText(month1.getIndustrials());

                requestQueue.stop();
            }


        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SectorPerformance.this,"The request failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,responseListener,errorListener);

        requestQueue.add(stringRequest);
    }
    public void Month3loadSectorPerformance()
    {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://www.alphavantage.co/query?function=SECTOR&apikey=27IHIPCVCKBHRMXF";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final String apiResponse = response;
                SectorPerformanceAPI sectorApiReponse = gson.fromJson(apiResponse,SectorPerformanceAPI.class);


                TextView itValue = findViewById(R.id.itValue);
                TextView energyValue = findViewById(R.id.energyValue);
                TextView utilValue = findViewById(R.id.utilValue);
                TextView commValue = findViewById(R.id.commValue);
                TextView matValue = findViewById(R.id.matValue);
                TextView consumValue = findViewById(R.id.consumValue);
                TextView estateValue = findViewById(R.id.estateValue);
                TextView healthValue = findViewById(R.id.healthValue);
                TextView industValue = findViewById(R.id.industrialValue);


                SectorPerformanceAPI.Month3 month3 = sectorApiReponse.getMonth3();

                itValue.setText(month3.getInformationTech());
                energyValue.setText(month3.getEnergy());
                utilValue.setText(month3.getUtilities());
                commValue.setText(month3.getCommServices());
                matValue.setText(month3.getMaterials());
                consumValue.setText(month3.getConsumerDis());
                estateValue.setText(month3.getRealestate());
                healthValue.setText(month3.getHealthcare());
                industValue.setText(month3.getIndustrials());

                requestQueue.stop();
            }


        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SectorPerformance.this,"The request failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,responseListener,errorListener);

        requestQueue.add(stringRequest);
    }
    public void YTDloadSectorPerformance()
    {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://www.alphavantage.co/query?function=SECTOR&apikey=27IHIPCVCKBHRMXF";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final String apiResponse = response;
                SectorPerformanceAPI sectorApiReponse = gson.fromJson(apiResponse,SectorPerformanceAPI.class);


                TextView itValue = findViewById(R.id.itValue);
                TextView energyValue = findViewById(R.id.energyValue);
                TextView utilValue = findViewById(R.id.utilValue);
                TextView commValue = findViewById(R.id.commValue);
                TextView matValue = findViewById(R.id.matValue);
                TextView consumValue = findViewById(R.id.consumValue);
                TextView estateValue = findViewById(R.id.estateValue);
                TextView healthValue = findViewById(R.id.healthValue);
                TextView industValue = findViewById(R.id.industrialValue);



                SectorPerformanceAPI.YeartoDate ytd = sectorApiReponse.getYeartoDate();

                itValue.setText(ytd.getInformationTech());
                energyValue.setText(ytd.getEnergy());
                utilValue.setText(ytd.getUtilities());
                commValue.setText(ytd.getCommServices());
                matValue.setText(ytd.getMaterials());
                consumValue.setText(ytd.getConsumerDis());
                estateValue.setText(ytd.getRealestate());
                healthValue.setText(ytd.getHealthcare());
                industValue.setText(ytd.getIndustrials());

                requestQueue.stop();
            }


        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SectorPerformance.this,"The request failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,responseListener,errorListener);

        requestQueue.add(stringRequest);
    }
    public void Year3loadSectorPerformance()
    {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://www.alphavantage.co/query?function=SECTOR&apikey=27IHIPCVCKBHRMXF";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final String apiResponse = response;
                SectorPerformanceAPI sectorApiReponse = gson.fromJson(apiResponse,SectorPerformanceAPI.class);


                TextView itValue = findViewById(R.id.itValue);
                TextView energyValue = findViewById(R.id.energyValue);
                TextView utilValue = findViewById(R.id.utilValue);
                TextView commValue = findViewById(R.id.commValue);
                TextView matValue = findViewById(R.id.matValue);
                TextView consumValue = findViewById(R.id.consumValue);
                TextView estateValue = findViewById(R.id.estateValue);
                TextView healthValue = findViewById(R.id.healthValue);
                TextView industValue = findViewById(R.id.industrialValue);


                SectorPerformanceAPI.Year3 year3 = sectorApiReponse.getYear3();

                itValue.setText(year3.getInformationTech());
                energyValue.setText(year3.getEnergy());
                utilValue.setText(year3.getUtilities());
                commValue.setText(year3.getCommServices());
                matValue.setText(year3.getMaterials());
                consumValue.setText(year3.getConsumerDis());
                estateValue.setText(year3.getRealestate());
                healthValue.setText(year3.getHealthcare());
                industValue.setText(year3.getIndustrials());

                requestQueue.stop();
            }


        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SectorPerformance.this,"The request failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,responseListener,errorListener);

        requestQueue.add(stringRequest);
    }
    public void Year5loadSectorPerformance()
    {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://www.alphavantage.co/query?function=SECTOR&apikey=27IHIPCVCKBHRMXF";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final String apiResponse = response;
                SectorPerformanceAPI sectorApiReponse = gson.fromJson(apiResponse,SectorPerformanceAPI.class);

                TextView itValue = findViewById(R.id.itValue);
                TextView energyValue = findViewById(R.id.energyValue);
                TextView utilValue = findViewById(R.id.utilValue);
                TextView commValue = findViewById(R.id.commValue);
                TextView matValue = findViewById(R.id.matValue);
                TextView consumValue = findViewById(R.id.consumValue);
                TextView estateValue = findViewById(R.id.estateValue);
                TextView healthValue = findViewById(R.id.healthValue);
                TextView industValue = findViewById(R.id.industrialValue);


                SectorPerformanceAPI.Year5 year5 = sectorApiReponse.getYear5();

                itValue.setText(year5.getInformationTech());
                energyValue.setText(year5.getEnergy());
                utilValue.setText(year5.getUtilities());
                commValue.setText(year5.getCommServices());
                matValue.setText(year5.getMaterials());
                consumValue.setText(year5.getConsumerDis());
                estateValue.setText(year5.getRealestate());
                healthValue.setText(year5.getHealthcare());
                industValue.setText(year5.getIndustrials());

                requestQueue.stop();
            }


        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SectorPerformance.this,"The request failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,responseListener,errorListener);

        requestQueue.add(stringRequest);
    }
    public void Year10loadSectorPerformance()
    {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://www.alphavantage.co/query?function=SECTOR&apikey=27IHIPCVCKBHRMXF";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final String apiResponse = response;
                SectorPerformanceAPI sectorApiReponse = gson.fromJson(apiResponse,SectorPerformanceAPI.class);


                TextView itValue = findViewById(R.id.itValue);
                TextView energyValue = findViewById(R.id.energyValue);
                TextView utilValue = findViewById(R.id.utilValue);
                TextView commValue = findViewById(R.id.commValue);
                TextView matValue = findViewById(R.id.matValue);
                TextView consumValue = findViewById(R.id.consumValue);
                TextView estateValue = findViewById(R.id.estateValue);
                TextView healthValue = findViewById(R.id.healthValue);
                TextView industValue = findViewById(R.id.industrialValue);



                SectorPerformanceAPI.Year10 year10 = sectorApiReponse.getYear10();

                itValue.setText(year10.getInformationTech());
                energyValue.setText(year10.getEnergy());
                utilValue.setText(year10.getUtilities());
                commValue.setText(year10.getCommServices());
                matValue.setText(year10.getMaterials());
                consumValue.setText(year10.getConsumerDis());
                estateValue.setText(year10.getRealestate());
                healthValue.setText(year10.getHealthcare());
                industValue.setText(year10.getIndustrials());

                requestQueue.stop();
            }


        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SectorPerformance.this,"The request failed: " + error.getMessage(), Toast.LENGTH_LONG).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,responseListener,errorListener);

        requestQueue.add(stringRequest);
    }
}
