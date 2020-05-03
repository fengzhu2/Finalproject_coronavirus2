package com.example.finalprojectcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    private Button miniGame, button;
    private TextView tipsRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tipsRandom = findViewById(R.id.randomTips);
        miniGame = findViewById(R.id.minigame);
        miniGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMiniGame();
            }
        });
        button = findViewById(R.id.random);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random newTips = new Random();
                int i = newTips.nextInt(tips.length);
                tipsRandom.setText(tips[i]);
            }
        });
    }
    public void openMiniGame() {
        Intent intent = new Intent(this, MiniGame.class);
        startActivity(intent);
    }
    private String tips[] = {"STAY home as much as you can", "KEEP a safe distance", "WASH hands often",
    "Call ahead when feeling sick", "Clean and disinfect frequently touched objects and surfaces daily",
    "Cover your cough or sneeze with a tissue", "WEAR a mask when going out", "COVER your face when going out",
    "USE a household disinfectant","Actually following the stay home orders"};
}
