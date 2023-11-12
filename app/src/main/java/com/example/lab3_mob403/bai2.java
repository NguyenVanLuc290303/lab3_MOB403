package com.example.lab3_mob403;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.lab3_mob403.app.appController;

import org.json.JSONArray;
import org.json.JSONObject;

public class bai2 extends AppCompatActivity {


    // json object response url
    private String urlJsonObj =
            "http://192.168.1.8/lab3_MOB403/person_object.json";
    // json array response url
    private String urlJsonArry =
            "http://192.168.1.8/lab3_MOB403/person_array.json";
    private static String TAG = bai2.class.getSimpleName();
    Button btn_object , btn_array;
    TextView tv_res;

    String jsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        btn_object = findViewById(R.id.btn_object);
        btn_array = findViewById(R.id.btn_array);
        tv_res = findViewById(R.id.tv_responsive);
        btn_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeJsonObjectRequest();
            }
        });
        btn_array.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeJsonArrayRequest();
            }
        });
    }

    private void makeJsonObjectRequest() {

        JsonObjectRequest jsonObjReq = new
                JsonObjectRequest(Request.Method.GET, urlJsonObj,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.d(TAG, jsonObject.toString());
                try {
                    // Parsing json object response
// response will be a json object
                    String name = jsonObject.getString("name");
                    String email = jsonObject.getString("email");
                    JSONObject phone = jsonObject.getJSONObject("phone");
                    String home = phone.getString("home");
                    String mobile = phone.getString("mobile");
                    jsonResponse = "";
                    jsonResponse += "Name: " + name + "\n\n";
                    jsonResponse += "Email: " + email + "\n\n";
                    jsonResponse += "Home: " + home + "\n\n";
                    jsonResponse += "Phone: " + mobile + "\n\n";
                    tv_res.setText(jsonResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error: " +
                            e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                VolleyLog.d(TAG, "Error: " + volleyError.getMessage());
                Toast.makeText(getApplicationContext(), "Error: " +
                        volleyError.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
        // Adding request to request queue
        appController.getInstance().addToRequestQueue(jsonObjReq);
    }

    private void makeJsonArrayRequest() {
        JsonArrayRequest arrayRequest = new JsonArrayRequest(urlJsonArry,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        Log.d(TAG, jsonArray.toString());
                        try {
                            jsonResponse = "";
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject person = (JSONObject) jsonArray.get(i);
                                String name = person.getString("name");
                                String email = person.getString("email");
                                JSONObject phone = person.getJSONObject("phone");
                                String home = phone.getString("home");
                                String mobile = phone.getString("mobile");
                                jsonResponse += "Name: " + name + "\n\n";
                                jsonResponse += "Email: " + email + "\n\n";
                                jsonResponse += "Home: " + home + "\n\n";
                                jsonResponse += "Mobile: " + mobile + "\n\n";
                            }
                            tv_res.setText(jsonResponse);
                        } catch (Exception e) {
                            e.printStackTrace();
//                            Toast.makeText(getApplicationContext(),"Error:
//                                    "+e.getMessage(),Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                VolleyLog.d(TAG,"Error: "+ volleyError.getMessage());

//                Toast.makeText(getApplicationContext(),volleyError.getMessage(),Toast.LENGTH
//                        _LONG).show();
            }

        });
        appController.getInstance().addToRequestQueue(arrayRequest);

    }


}