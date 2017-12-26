package cmps312.geocod;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
List<Address> add;
    Double lat=25.334690;
    Double lon=51.472882;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Geocoder g=new Geocoder(this, Locale.getDefault());
        try {
            add=g.getFromLocation(lat,lon,1);
            String s="";
            for (int i=0;i<add.get(0).getMaxAddressLineIndex();i++)
                s=s+add.get(0).getAddressLine(i)+"\n";

            Toast.makeText(this,s,Toast.LENGTH_LONG).show();
            String con=add.get(0).getCountryName();
            Toast.makeText(this,con,Toast.LENGTH_LONG).show();
            String city=add.get(0).getLocality();
            Toast.makeText(this,city,Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
