package com.example.myapplication.ui.theme;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.theme.TransactionModel;
import com.example.myapplication.ui.theme.TransactionAdapter;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    ArrayList<com.example.myapplication.ui.theme.TransactionModel> list;

    public TransactionAdapter(ArrayList<com.example.myapplication.ui.theme.TransactionModel> list) {
        this.list = list;
    }

    public TransactionAdapter(ArrayList<com.example.myapplication.ui.theme.TransactionModel> list) {
    }

    public TransactionAdapter(ArrayList<com.example.myapplication.ui.theme.TransactionModel> list) {
    }

    public TransactionAdapter(ArrayList<com.example.myapplication.ui.theme.TransactionModel> list) {

    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaction, parent, false);
        return new TransactionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        TransactionModel model = list.get(position);

        holder.tvDescription.setText(model.getDescription());
        holder.tvAmount.setText("₹ " + model.getAmount());
        holder.tvType.setText(model.getType());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TransactionViewHolder extends RecyclerView.ViewHolder {

        TextView tvDescription, tvAmount, tvType;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvType = itemView.findViewById(R.id.tvType);
        }
    }
}