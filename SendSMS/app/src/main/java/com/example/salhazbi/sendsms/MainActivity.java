package com.example.salhazbi.sendsms;

import android.Manifest;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   public static final int r=1;
    EditText to, msg;
    SmsManager s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         to=(EditText)findViewById(R.id.editText) ;
        msg=(EditText)findViewById(R.id.editText2) ;
         s=SmsManager.getDefault();
    }
    public void sendSMS(View v)
    {

        int isAllowed=checkSelfPermission(Manifest.permission.SEND_SMS);

        if (isAllowed!=getPackageManager().PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},r);



    }
@Override
    public void onRequestPermissionsResult(int r, String per[], int grants[])
{
   if (r==1)
       if (per.length>0 && grants[0]==getPackageManager().PERMISSION_GRANTED) {
           String no=to.getText().toString();
           String contents=msg.getText().toString();
           s.sendTextMessage(no, null, contents, null, null);
       }
    else
        Toast.makeText(this,"No permission",Toast.LENGTH_LONG).show();
}


}
