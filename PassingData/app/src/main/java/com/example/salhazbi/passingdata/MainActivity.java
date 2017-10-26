package com.example.salhazbi.passingdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(EditText) findViewById(R.id.editText);
        t2=(EditText) findViewById(R.id.editText2);

    }
    public void callSecondActivity(View v)
    {
        Intent i=new Intent(this,SecondActivity.class);
        i.putExtra("fname",t1.getText().toString());
        i.putExtra("lname",t2.getText().toString());
        startActivity(i);
    }
}
