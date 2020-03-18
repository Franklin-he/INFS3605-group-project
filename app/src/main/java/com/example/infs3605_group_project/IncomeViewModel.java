package com.example.infs3605_group_project;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class IncomeViewModel extends AndroidViewModel {

    private IncomeRepository repository;
    private LiveData<List<Income>> allIncomes;

    public IncomeViewModel(@NonNull Application application) {
        super(application);
        repository = new IncomeRepository(application);
        allIncomes = repository.getAllIncomes();
    }

    public void insert(Income income) {
        repository.insert(income);
    }

    public void update(Income income) {
        repository.update(income);
    }

    public void delete(Income income) {
        repository.delete(income);
    }

    public void deleteAllIncomes() {
        repository.deleteAllNotes();
    }

    public LiveData<List<Income>> getAllIncomes() {
        return allIncomes;
    }

}
