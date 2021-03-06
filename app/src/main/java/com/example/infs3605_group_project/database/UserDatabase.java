package com.example.infs3605_group_project.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


//this real db is used to store different user accounts information
@Database(entities = {User.class}, version = 1, exportSchema = false)

public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();


    public static UserDatabase userDatabase;

    public static UserDatabase getInstance(Context context) {
        if (userDatabase == null) {
            userDatabase = Room.databaseBuilder(context, UserDatabase.class,"appdb").allowMainThreadQueries().build();
        }
        return userDatabase;
    }
}
