package com.example.infs3605_group_project.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.infs3605_group_project.database.IncomeDao;
import com.example.infs3605_group_project.database.IncomeDatabase;
import com.example.infs3605_group_project.entities.Income;

import java.util.List;

public class IncomeRepository {
    private IncomeDao incomeDao;
    private LiveData<List<Income>> allIncomes;

    public IncomeRepository(Application application) {
        IncomeDatabase database = IncomeDatabase.getInstance(application);
        incomeDao = database.incomeDao();
        allIncomes = incomeDao.getAllIncomes();
    }

    public void insert(Income income){
        new InsertIncomeAsyncTask(incomeDao).execute(income);
    }

    public void update(Income income){
        new UpdateIncomeAsyncTask(incomeDao).execute(income);
    }

    public void delete(Income income){
        new DeleteIncomeAsyncTask(incomeDao).execute(income);
    }

    public void deleteAllNotes(){
        new DeleteAllIncomesAsyncTask(incomeDao).execute();
    }

    public LiveData<List<Income>> getAllIncomes() {
        return allIncomes;
    }

    private static class InsertIncomeAsyncTask extends AsyncTask<Income, Void, Void> {
        private IncomeDao incomeDao;

        private InsertIncomeAsyncTask(IncomeDao incomeDao){
            this.incomeDao = incomeDao;
        }
        @Override
        protected Void doInBackground(Income... incomes) {
            incomeDao.insert(incomes[0]);
            return null;
        }
    }

    private static class UpdateIncomeAsyncTask extends AsyncTask<Income, Void, Void> {
        private IncomeDao incomeDao;

        private UpdateIncomeAsyncTask(IncomeDao incomeDao){
            this.incomeDao = incomeDao;
        }
        @Override
        protected Void doInBackground(Income... incomes) {
            incomeDao.update(incomes[0]);
            return null;
        }
    }

    private static class DeleteIncomeAsyncTask extends AsyncTask<Income, Void, Void> {
        private IncomeDao incomeDao;

        private DeleteIncomeAsyncTask(IncomeDao incomeDao){
            this.incomeDao = incomeDao;
        }
        @Override
        protected Void doInBackground(Income... incomes) {
            incomeDao.delete(incomes[0]);
            return null;
        }
    }

    private static class DeleteAllIncomesAsyncTask extends AsyncTask<Void, Void, Void> {
        private IncomeDao incomeDao;

        private DeleteAllIncomesAsyncTask(IncomeDao incomeDao){
            this.incomeDao = incomeDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            incomeDao.deleteAllIncomes();
            return null;
        }
    }

}
