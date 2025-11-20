package com.example.myapplication.ui.theme;

public class TransactionModel {

    private double amount;
    private String description;
    private String type; // Income or Expense

    public TransactionModel(double amount, String description, String type) {
        this.amount = amount;
        this.description = description;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}