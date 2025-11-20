package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.ui.theme.AddTransactionActivity;
import com.example.myapplication.ui.theme.DatabaseClient;
import com.example.myapplication.ui.theme.TransactionAdapter;
import com.example.myapplication.ui.theme.TransactionModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvBalance;
    Button btnAdd;
    RecyclerView recyclerView;

    ArrayList<TransactionModel> list = new ArrayList<>();
    TransactionAdapter adapter;

    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBalance = findViewById(R.id.tvBalance);
        btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TransactionAdapter(list);
        recyclerView.setAdapter(adapter);

        // Reload data after returning
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> loadData()
        );

        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddTransactionActivity.class);
            launcher.launch(intent);
        });

        loadData();  // first load
    }

    private void loadData() {
        list.clear();

        List<com.example.myapplication.TransactionEntity> entities =
                DatabaseClient.getInstance(getApplicationContext())
                        .getAppDatabase()
                        .transactionDao()
                        .getAllTransactions();

        double balance = 0;

        for (TransactionEntity e : entities) {

            list.add(new TransactionModel(
                    e.getAmount(),
                    e.getDescription(),
                    e.getType()
            ));

            if (e.getType().equals("Income"))
                balance += e.getAmount();
            else
                balance -= e.getAmount();
        }

        adapter.notifyDataSetChanged();
        tvBalance.setText("Balance: ₹ " + balance);
    }
}