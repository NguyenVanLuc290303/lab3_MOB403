package com.example.lab3_mob403;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab3_mob403.adapter.androidAdapter;
import com.example.lab3_mob403.adapter.bai4Adapter;
import com.example.lab3_mob403.modal.androidVersion;
import com.example.lab3_mob403.modal.contacts;
import com.example.lab3_mob403.modal.photos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class bai4 extends AppCompatActivity {
    RecyclerView rcv_contacts;
    bai4Adapter bai4Adapter;
    private List<photos> photoList;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        rcv_contacts = findViewById(R.id.rcv_coct);
        fab = findViewById(R.id.fab);
        rcv_contacts.setLayoutManager(new LinearLayoutManager(this));

        photoList = new ArrayList<>();
        bai4Adapter = new bai4Adapter(this, photoList);
        rcv_contacts.setAdapter(bai4Adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (internetconnection.checkConnection(getApplicationContext())){
                    loadJson();
                    Toast.makeText(getApplicationContext(),"downloaded" , Toast.LENGTH_SHORT).show();

            }else {
                    Toast.makeText(getApplicationContext(),"internet not connected" , Toast.LENGTH_SHORT).show();}
            }
        });

    }

    private void loadJson() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/") // Thay thế bằng URL API thực tế
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIContacts photoApi = retrofit.create(APIContacts.class);
        Call<List<photos>> call = photoApi.getPhoto();

        call.enqueue(new Callback<List<photos>>() {
            @Override
            public void onResponse(Call<List<photos>> call, Response<List<photos>> response) {
                if (response.isSuccessful()) {
                    photoList.addAll(response.body());
                    bai4Adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<photos>> call, Throwable t) {
                Toast.makeText(bai4.this, "Failed to load photos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}