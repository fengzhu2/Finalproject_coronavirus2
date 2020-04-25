package com.example.finalprojectcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;


import java.lang.ref.ReferenceQueue;

public class MainActivity extends AppCompatActivity {
    private TextView caseUpdate;
    private Button tips;
    private Button map;
    private Button trends;
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        caseUpdate = (TextView) findViewById(R.id.cases);
        tips = (Button) findViewById(R.id.tips);
        tips.setOnClickListener(clickListener);
        map = (Button) findViewById(R.id.map);
        map.setOnClickListener(clickListener);
        trends = (Button) findViewById(R.id.trends);
        trends.setOnClickListener(clickListener);
    }
}

