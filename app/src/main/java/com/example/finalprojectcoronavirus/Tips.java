package com.example.finalprojectcoronavirus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tips extends AppCompatActivity {
    private TextView caseUpdate, caseDeath, caseRecovered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        caseUpdate = findViewById(R.id.cases);
        caseDeath = findViewById(R.id.deathCases);
        caseRecovered = findViewById(R.id.recoveredCases);
        getNumber();
    }

    private void getNumber() {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://api.thevirustracker.com/free-api?countryTotal=US";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("countrydata");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject countrydata = jsonArray.getJSONObject(i);
                                int number = countrydata.getInt("total_cases");
                                int death = countrydata.getInt("total_deaths");
                                int recover = countrydata.getInt("total_recovered");
                                requestQueue.stop();
                                caseUpdate.append(String.valueOf(number));
                                caseDeath.append(String.valueOf(death));
                                caseRecovered.append(String.valueOf(recover));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
