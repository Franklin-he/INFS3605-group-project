package com.example.infs3605_group_project.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "income_table")
public class Income {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private Long monthly_total_income;

    private Long monthly_total_saving;

    private Long monthly_spendable_income;

    public Income(Long monthly_total_income, Long monthly_total_saving, Long monthly_spendable_income) {
        this.monthly_total_income = monthly_total_income;
        this.monthly_total_saving = monthly_total_saving;
        this.monthly_spendable_income = monthly_spendable_income;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Long getMonthly_total_income() {
        return monthly_total_income;
    }

    public Long getMonthly_total_saving() {
        return monthly_total_saving;
    }

    public Long getMonthly_spendable_income() {
        return monthly_spendable_income;
    }


}
