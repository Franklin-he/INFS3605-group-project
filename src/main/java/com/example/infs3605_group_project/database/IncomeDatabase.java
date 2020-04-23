package com.example.infs3605_group_project.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Income.class, version = 2, exportSchema = false)
public abstract class IncomeDatabase extends RoomDatabase {

    private static IncomeDatabase instance;

    public abstract IncomeDao incomeDao();

    //creates an incomeDB instance
    public static synchronized IncomeDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    IncomeDatabase.class, "income_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    //manual insert into DB for testing
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void> {
        private IncomeDao incomeDao;

        private PopulateDBAsyncTask(IncomeDatabase db){
            incomeDao = db.incomeDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            //incomeDao.insert(new Income("job", Long.parseLong("2000")));
            //incomeDao.insert(new Income("tutoring", Long.parseLong("500")));
            return null;
        }
    }

}
