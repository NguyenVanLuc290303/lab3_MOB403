package com.example.lab3_mob403.AsyncTask;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3_mob403.MainActivity;
import com.example.lab3_mob403.adapter.contactAdapter;
import com.example.lab3_mob403.modal.contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class HTTP_AsyncTask extends AsyncTask<Void , Void , Void> {

    String duongdan = MainActivity.NameServer;
    Context context;
    RecyclerView rcv_contact;
    contactAdapter contactAdapter;

    public HTTP_AsyncTask(Context context, RecyclerView rcv_contact) {
        this.context = context;
        this.rcv_contact = rcv_contact;
    }
    String str;
    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL(duongdan);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line = "";
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            str = stringBuffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        try {
            JSONObject jsonObject = new JSONObject(str);
//            Log.d(TAG, "onPostExecute: " + str);
            JSONArray jsonArray = jsonObject.getJSONArray("contacts");

            ArrayList arrayList = new ArrayList();
            // looping through all Contacts
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String idc = object.getString("id");
                String name = object.getString("name");
                String email = object.getString("email");
                String address = object.getString("address");
                String gender = object.getString("gender");

                JSONObject phone = object.getJSONObject("phone");
                String mobile = phone.getString("mobile");
                String home = phone.getString("home");
                String office = phone.getString("office");
                contact ct = new contact(idc,name,email,address,gender,mobile,home,office);

                arrayList.add(ct);

            }
            Log.d(TAG, "onPostExecute: " + arrayList);
            contactAdapter =  new contactAdapter(arrayList,context);
            rcv_contact.setAdapter(contactAdapter);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Json parsing error: " + e.getMessage());
        }

    }
}
