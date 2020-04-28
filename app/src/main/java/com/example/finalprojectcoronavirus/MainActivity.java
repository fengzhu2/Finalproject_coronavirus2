package com.example.finalprojectcoronavirus;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private Button tips;
    private Button map;
    private Button actualTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tips = findViewById(R.id.tips);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTips();
            }
        });
        map = findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });
        actualTips = findViewById(R.id.button);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain2();
            }
        });
    }

    private void openMain2() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }

    /** this actually opens cases, tried to change it but app kept crashing after the change*/
    public void openTips() {
        Intent intent = new Intent(this, Tips.class);
        startActivity(intent);
    }

    public void openMap() {
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }


}


