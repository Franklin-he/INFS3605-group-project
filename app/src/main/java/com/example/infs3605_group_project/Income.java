package com.example.infs3605_group_project;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "income_table")
public class Income {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String income_name;

    private Long income_amount;

    public Income(String income_name, Long income_amount) {
        this.income_name = income_name;
        this.income_amount = income_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIncome_name() {
        return income_name;
    }

    public Long getIncome_amount() {
        return income_amount;
    }
}
