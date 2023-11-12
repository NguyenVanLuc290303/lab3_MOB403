package com.example.lab3_mob403;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.lab3_mob403.adapter.androidAdapter;
import com.example.lab3_mob403.modal.androidVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Callback;

import retrofit2.converter.gson.GsonConverterFactory;

public class bai3 extends AppCompatActivity {
    RecyclerView rcv_bai3;
//    private ArrayList<androidVersion> data;
    private androidAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        rcv_bai3 = findViewById(R.id.rcv_bai3);
        loadJson();
    }

    private void loadJson() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.8/lab3_MOB403/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface apiService = retrofit.create(RequestInterface.class);
        Call<jsonResponse> call = apiService.getJSON();
        call.enqueue(new Callback<jsonResponse>() {
            @Override
            public void onResponse(Call<jsonResponse> call, Response<jsonResponse> response) {
                if (response.isSuccessful()) {
                    jsonResponse jsonResponse = response.body();
                    Log.d(TAG, "onResponse: " + response);
                    if (jsonResponse != null) {
                        ArrayList<androidVersion> androidVersions = jsonResponse.getAndroid();
                        Log.d(TAG, "onList: " +androidVersions);
                        adapter = new androidAdapter(bai3.this,androidVersions);
                        rcv_bai3.setAdapter(adapter);
//                        adapter.notifyDataSetChanged();
                    }
                } else {
                    // Xử lý lỗi từ server
                }
            }

            @Override
            public void onFailure(Call<jsonResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}