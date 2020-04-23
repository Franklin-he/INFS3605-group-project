package com.example.infs3605_group_project.activities;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infs3605_group_project.R;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ETFsLineChart extends AppCompatActivity{

    private com.github.mikephil.charting.charts.LineChart lChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.etfs);
        lChart = (com.github.mikephil.charting.charts.LineChart) findViewById(R.id.line_chart_1);
        lChart.setDragEnabled(true);
        lChart.setScaleEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<>();
        SharedPreferences sharedPreferences = getSharedPreferences("incomes", MODE_PRIVATE);
        Long t_savings = sharedPreferences.getLong("total_savings", 0);

        Double savings = (double) t_savings;


        int year = Calendar.getInstance().get(Calendar.YEAR);

        String[] years = new String[20];

        List<String> xAxisValues;

        for (int i = 0; i < 20; i++) {
            years[i] = String.valueOf(year + i);
            yValues.add(new Entry(i, Float.valueOf(String.valueOf(savings))));
            savings = savings + savings * 0.1;
        }


        LineDataSet set1 = new LineDataSet(yValues, "Future savings");
        set1.setFillAlpha(2000);
        set1.setLineWidth(2f);
        set1.setValueTextSize(10f);


        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        lChart.setData(data);
        lChart.getAxisRight().setEnabled(false);
        lChart.getDescription().setEnabled(false);

        XAxis xAxis = lChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        lChart.getXAxis().setValueFormatter(new com.github.mikephil.charting.formatter.IndexAxisValueFormatter(years));
        xAxis.setGranularity(1);
    }
}
