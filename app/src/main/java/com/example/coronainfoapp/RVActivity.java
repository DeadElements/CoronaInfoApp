package com.example.coronainfoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RVActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    String s1[], s2[];

    int images[] = {R.drawable.yellowdot,R.drawable.dot_red,R.drawable.yellowdot,R.drawable.yellowdot,
            R.drawable.green_dot, R.drawable.yellowdot, R.drawable.dot_red, R.drawable.yellowdot, R.drawable.green_dot};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_v);

        setTitle("Aktive Coronafälle in Österreich");


        FloatingActionButton fab2 = findViewById(R.id.go_to_map);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RVActivity.this, MapActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        FloatingActionButton fab3 = findViewById(R.id.homefab);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RVActivity.this, MainActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        recyclerview = findViewById(R.id.recyclerview);

        s1 = getResources().getStringArray(R.array.programming_languages);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(RVActivity.this, s1, s2 ,images);
        recyclerview.setAdapter(myAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(RVActivity.this));

    }
}