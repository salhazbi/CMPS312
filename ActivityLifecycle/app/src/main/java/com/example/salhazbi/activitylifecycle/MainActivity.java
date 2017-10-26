package com.example.salhazbi.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logData("OnCreate");
    }
    public void logData(String s)
    {
        Log.i("Trace","Main activity :"+ s);
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
    public void callSecond(View v)
    {
        Intent i=new Intent(this,SecondActivity.class);
        startActivity(i);
    }
}
