package cmps312.fusedlocation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationListener;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private Location loc;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 3);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 3);

        if (!isPlayServiceAvailable()) {
            Toast.makeText(this, "Goog service is not available", Toast.LENGTH_LONG).show();
            return;
        } else {

            Toast.makeText(this, "Goog service is available", Toast.LENGTH_LONG).show();
            buildGoogleApiClient();
            mGoogleApiClient.connect();
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        loc = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (loc==null)
            Toast.makeText(this,"null location", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,loc.getLatitude()+"\n"+loc.getLongitude(), Toast.LENGTH_LONG).show();

        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(50);
        mLocationRequest.setSmallestDisplacement(1);
        Toast.makeText(this,"so far so good", Toast.LENGTH_LONG).show();
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {  }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) { }


    public boolean isPlayServiceAvailable() {
        // Check that Google Play Services are available
        int resultCode =  GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        // If Google Play services is available

        return (ConnectionResult.SUCCESS == resultCode);
    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this,"helloooo", Toast.LENGTH_LONG).show();
        Toast.makeText(this,location.getLatitude()+"",Toast.LENGTH_LONG).show();
        Toast.makeText(this,location.getLongitude()+"",Toast.LENGTH_LONG).show();
    }
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

}
