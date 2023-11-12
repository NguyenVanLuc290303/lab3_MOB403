package com.example.lab3_mob403;

import com.example.lab3_mob403.modal.androidVersion;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;



public interface RequestInterface {
    @GET("jsonandroid.json")
    Call<jsonResponse> getJSON();
}
