package com.example.salhazbi.passingdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String firstName=getIntent().getStringExtra("fname");
        String lastName=getIntent().getStringExtra("lname");
        t=(TextView)findViewById(R.id.textView3);
        t.setText("Welcome "+firstName+" "+lastName);
    }
}
