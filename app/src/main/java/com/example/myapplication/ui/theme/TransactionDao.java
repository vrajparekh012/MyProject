package com.example.myapplication.ui.theme;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TransactionDao {

    @Insert
    void insert(com.example.myapplication.TransactionEntity transaction);

    @Query("SELECT * FROM transactions ORDER BY id DESC")
    List<com.example.myapplication.TransactionEntity> getAllTransactions();
}