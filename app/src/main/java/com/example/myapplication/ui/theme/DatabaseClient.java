package com.example.myapplication.ui.theme;

import android.content.Context;

import androidx.room.Room;

import com.example.myapplication.ui.theme.AppDatabase;

public class DatabaseClient {

    private static DatabaseClient instance;
    private final AppDatabase appDatabase;

    private DatabaseClient(Context context) {
        appDatabase = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class,
                "expense_db"
        ).allowMainThreadQueries().build();
    }

    public static synchronized DatabaseClient getInstance(Context ctx) {
        if (instance == null) {
            instance = new DatabaseClient(ctx);
        }
        return instance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}