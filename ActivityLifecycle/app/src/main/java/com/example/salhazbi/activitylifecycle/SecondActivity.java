package com.example.salhazbi.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        logData("onCreate");
    }
    public void logData(String s)
    {
        Log.i("Trace","Second activity :"+ s);
    }
    protected void onStart()
    {
        super.onStart();
        logData("Onstart");
    }
    protected void onResume()
    {
        super.onResume();
        logData("OnResume");
    }
    protected void onStop()
    {
        super.onStop();
        logData("OnStop");
    }
    protected void onPause()
    {
        super.onPause();
        logData("OnPause");
    }
    protected void onDestroy()
    {
        super.onDestroy();
        logData("OnDestroy");
    }
    protected void onRestart()
    {
        super.onRestart();
        logData("OnRestart");
    }
}

