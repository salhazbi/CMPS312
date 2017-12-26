package cmps312.map3;

import android.renderscript.Double2;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
EditText lat,lon;
    private GoogleMap mMap;
    double dLat=25.375;
    double dLon=51.489;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        lat=(EditText)findViewById(R.id.editText);
        lon=(EditText)findViewById(R.id.editText2);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
         mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
public void update(View v)
{
     dLat= Double.parseDouble(lat.getText().toString());
     dLon=Double.parseDouble(lon.getText().toString());
    mapFragment.getMapAsync(this);
}
    public void zoomIn(View v)
    {
        mMap.animateCamera(CameraUpdateFactory.zoomIn());


    }
    public void zoomOut(View v)
    {
        mMap.animateCamera(CameraUpdateFactory.zoomOut());

    }
        @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng loc = new LatLng(dLat, dLon);
        mMap.clear();
       mMap.addMarker(new MarkerOptions().position(loc).title("new marker"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));

    }
}
