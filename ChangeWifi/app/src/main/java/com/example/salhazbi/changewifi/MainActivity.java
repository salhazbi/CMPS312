package com.example.salhazbi.changewifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void turnWifiOn(View v)
    {
        WifiManager w= (WifiManager) this.getApplicationContext().
                getSystemService(Context.WIFI_SERVICE);
                  w.setWifiEnabled(true);
    }
    public void turnWifiOff(View v)
    {
        WifiManager w= (WifiManager) this.getApplicationContext().
                getSystemService(Context.WIFI_SERVICE);
        w.setWifiEnabled(false);
    }
}
