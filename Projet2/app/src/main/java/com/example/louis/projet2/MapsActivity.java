package com.example.louis.projet2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
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



public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
    Question question = new Question();
    private GoogleMap mMap;
    FusedLocationProviderClient fusedLocationClient;
    Location currentLocation;
    Location targetLocation;
    String result;
    Marker mCurrent;


    public void onClickLocation(View v)
    {
        Log.e("Testtt", "Click bouton");
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
        Log.e("Testtt", "0");
        fusedLocationClient.getLastLocation().addOnSuccessListener(MapsActivity.this, new OnSuccessListener<Location>()
        {
            public void onSuccess(Location location)
            {
                Log.e("Testtt", "1");
                if (location != null)
                {
                    Log.e("Testtt", "2");
                    currentLocation = location;
                    System.out.println(location.getLatitude() + " : " + location.getLongitude());
                }


                float[] distance = new float[1];
                Location.distanceBetween(targetLocation.getLatitude(), targetLocation.getLongitude(), currentLocation.getLatitude(), currentLocation.getLongitude(), distance);

                if (mCurrent != null)
                {
                    mCurrent.remove();
                }

                LatLng current = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());

                mCurrent = mMap.addMarker(new MarkerOptions().position(current).title("Votre position"));
                mCurrent.setTag(0);
                Log.e("Testtt", "ça c'est ok 2");


                if (distance[0] < 30.0) {
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

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
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

        LatLng maisonLouis = new LatLng(47.442453, -0.494956);
        LatLng cathedrale = new LatLng(47.470895, -0.555397 );
        LatLng ralliement = new LatLng(47.471262, -0.551996);
        LatLng heron = new LatLng(47.469162, -0.570317);
        LatLng kiosque = new LatLng(47.470278, -0.545784);
        TextView txtv4 = (TextView) findViewById(R.id.txtv4);
        Log.e("Testtt", "Question actuelle" + question.getCurrentQuestion());


        if(question.getCurrentQuestion() == 1)
        {
            txtv4.setText("Rendez vous au 119 rue Jean Jaures, 49800 TRELAZE");
            mMap.addMarker(new MarkerOptions().position(maisonLouis).title("Louis"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(maisonLouis));

        }
        else
        {
            if(question.getCurrentQuestion() == 2)
            {
                txtv4.setText("Rendez vous à la cathédrale d'Angers pour découvrir la prochaine question");
                mMap.addMarker(new MarkerOptions().position(cathedrale).title("cathédrale"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(cathedrale));
            }
            else
            {
                if(question.getCurrentQuestion() == 3)
                {
                    txtv4.setText("Rendez vous place du ralliement pour découvrir la prochaine question");
                    mMap.addMarker(new MarkerOptions().position(ralliement).title("ralliement"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(ralliement));
                }
                else
                {
                    if(question.getCurrentQuestion() == 4)
                    {
                        txtv4.setText("Rendez vous au Héron Carré pour découvrir la prochaine question");
                        mMap.addMarker(new MarkerOptions().position(heron).title("heron"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(heron));
                    }
                }
            }
        }
    }
}
