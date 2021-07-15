package com.saed.logapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.LogHolder> {

    private final ArrayList<String> logs;

    public LogAdapter(ArrayList<String> logs) {
        this.logs = logs;
    }

    @NonNull
    @Override
    public LogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LogHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.log_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LogHolder holder, int position) {
        holder.textView.setText(logs.get(position));
    }

    @Override
    public int getItemCount() {
        return logs.size();
    }

    public static class LogHolder extends RecyclerView.ViewHolder {
        public final TextView textView;

        public LogHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
