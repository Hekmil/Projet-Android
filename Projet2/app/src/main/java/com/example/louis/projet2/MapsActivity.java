package com.example.louis.projet2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.location.FusedLocationProviderClient;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import java.util.ArrayList;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
    private GoogleMap mMap;
    FusedLocationProviderClient fusedLocationClient;
    Location currentLocation;
    Location targetLocation;
    String result;
    ArrayList<Question> questions = new ArrayList<>();
    Integer questionNumber;
    Marker mCurrent;


    public void onClickLocation(View v)
    {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.getLastLocation().addOnSuccessListener(MapsActivity.this, new OnSuccessListener<Location>()
        {
            public void onSuccess(Location location)
            {
                if (location != null)
                {
                    currentLocation = location;
                    System.out.println(location.getLatitude() + " : " + location.getLongitude());
                }


                float[] distance = new float[1];
                Location.distanceBetween(targetLocation.getLatitude(), targetLocation.getLongitude(), currentLocation.getLatitude(), currentLocation.getLongitude(), distance);

                if (mCurrent != null)
                    mCurrent.remove();

                LatLng current = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());

                mCurrent = mMap.addMarker(new MarkerOptions().position(current).title("Votre position"));
                mCurrent.setTag(0);


                if (distance[0] < 30.0)
                {
                    Intent i = new Intent(MapsActivity.this, QuestionActivity.class);
                    startActivity(i);
                } else {
                    result = "Vous n'êtes pas encore arrivé au point cible ! Vous êtes à " + (int) distance[0] + " mètres de la cible";
                    Toast.makeText(MapsActivity.this, result, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        requestPermissions();

        fusedLocationClient = LocationServices.getFusedLocationProviderClient().getLastLocation();

        targetLocation = new Location();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
