package com.example.lab3_mob403;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lab3_mob403.AsyncTask.HTTP_AsyncTask;

public class MainActivity extends AppCompatActivity {
    public  static final String NameServer = "http://192.168.1.8/lab3_MOB403/index.php";
    RecyclerView rcv_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv_contact = findViewById(R.id.rcv_contact);
        HTTP_AsyncTask http_asyncTask = new HTTP_AsyncTask(MainActivity.this,rcv_contact);
        http_asyncTask.execute();
    }
}