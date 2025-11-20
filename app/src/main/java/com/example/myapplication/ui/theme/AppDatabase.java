package com.example.myapplication.ui.theme;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.ui.theme.TransactionDao;

@Database(entities = {com.example.myapplication.TransactionEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TransactionDao transactionDao();
}