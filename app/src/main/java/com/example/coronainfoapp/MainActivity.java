package com.example.coronainfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialCardView materialCardView = findViewById(R.id.card);

        hideNavigationbar();
        randomQuote();
        currentCases();


    }

    private void randomQuote(){
        String[] quotes_array = getResources().getStringArray(R.array.quotes);

        final int random = new Random().nextInt((quotes_array.length - 0) + 1) + 0;
        TextView textViewQuote = findViewById(R.id.textViewQuote);
        textViewQuote.setText(quotes_array[random]);
    }

    private void hideNavigationbar() {
        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                                                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                                            View.SYSTEM_UI_FLAG_FULLSCREEN |
                                                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }

    private void currentCases() {
        TextView textViewCases = findViewById(R.id.cases);
        textViewCases.setText("1143");

    }


}