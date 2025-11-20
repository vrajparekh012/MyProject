package com.example.myapplication.ui.theme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.ui.theme.DatabaseClient;

public class AddTransactionActivity extends AppCompatActivity {

    EditText etAmount, etDescription;
    RadioButton rbIncome, rbExpense;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        etAmount = findViewById(R.id.etAmount);
        etDescription = findViewById(R.id.etDescription);
        rbIncome = findViewById(R.id.rbIncome);
        rbExpense = findViewById(R.id.rbExpense);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> saveTransaction());
    }

    private void saveTransaction() {
        String amountStr = etAmount.getText().toString().trim();
        String desc = etDescription.getText().toString().trim();

        if (amountStr.isEmpty()) {
            Toast.makeText(this, "Enter amount", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount = Double.parseDouble(amountStr);
        String type = rbIncome.isChecked() ? "Income" : "Expense";

        // Save into Room DB
        com.example.myapplication.TransactionEntity entity = new com.example.myapplication.TransactionEntity(amount, desc, type);
        DatabaseClient.getInstance(getApplicationContext())
                .getAppDatabase()
                .transactionDao()
                .insert(entity);

        setResult(RESULT_OK);
        finish();
    }
}