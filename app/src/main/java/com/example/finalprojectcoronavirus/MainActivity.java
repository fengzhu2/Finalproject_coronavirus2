package com.example.finalprojectcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;


import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private TextView caseUpdate;
    private Button tips;
    private Button map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        caseUpdate = findViewById(R.id.cases);
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
        getNumber();
    }
    public void openTips() {
        Intent intent = new Intent(this, Tips.class);
        startActivity(intent);
    }
    public void openMap() {
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }
    public void getNumber() {
        String link = "'https://api.thevirustracker.com/free-api?countryTotal=US";
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    caseUpdate.setText(jsonObject.getString("total_cases"));
                    requestQueue.stop();
                } catch (JSONException a) {
                    a.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.toString());
                caseUpdate.setText("error");
                requestQueue.stop();
            }
        });
        requestQueue.add(stringRequest);
    }

}

