package com.example.lab3_mob403;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

public class internetconnection {
    public static boolean checkConnection(@NonNull Context context) {
        return ((ConnectivityManager) context.getSystemService
                (Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() !=
                null;
    }
}
