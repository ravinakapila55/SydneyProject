package com.sydneyproject.util;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class MyApplication extends Application
{

    private static MyApplication instance;

    public static MyApplication getInstance()
    {
        return instance;
    }

    public static boolean hasNetwork()
    {
        return instance.checkIfHasNetwork();
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
        initSharedHelper();
    }


    private void initSharedHelper()
    {
        SharedPrefUtil.init(this);
    }

    public boolean checkIfHasNetwork()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
