package com.example.myapplication.ui.theme;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactions")
public class TransactionEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private double amount;
    private String description;
    private String type;

    public TransactionEntity(double amount, String description, String type) {
        this.amount = amount;
        this.description = description;
        this.type = type;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public double getAmount() { return amount; }

    public String getDescription() { return description; }

    public String getType() { return type; }
}