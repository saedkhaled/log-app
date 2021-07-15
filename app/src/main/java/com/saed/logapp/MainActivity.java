package com.saed.logapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> logs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.logRecyclerView);
        LogAdapter adapter = new LogAdapter(logs);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        Logger logger = new Logger();

        logger.logCatOutput().observe(this, s -> {
            logs.add(s);
            adapter.notifyDataSetChanged();
            rv.smoothScrollToPosition(logs.size() - 1);
        });
    }
}