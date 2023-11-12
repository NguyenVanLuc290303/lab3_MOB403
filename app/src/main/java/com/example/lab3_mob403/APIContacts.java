package com.example.lab3_mob403;

import com.example.lab3_mob403.modal.photos;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;

public interface APIContacts {
    @GET("photos")
    Call<List<photos>> getPhoto();
}
