package com.example.coronainfoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ManufacturerUtils;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    //Inizialize variables
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        hideNavigationbar();

        FloatingActionButton fab4 = findViewById(R.id.go_back_to_rv);
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, RVActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.google_map);
        mapFragment.getMapAsync(this);

        //Assign variables
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.google_map);

        //initialize fused location
        client = LocationServices.getFusedLocationProviderClient(MapActivity.this);

        //check permission
        if (ActivityCompat.checkSelfPermission(MapActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //when permission is granted
            //call method
            getCurrentLocation();
        } else {
            //when permission denied
            ActivityCompat.requestPermissions(MapActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

        }
    }

    private void hideNavigationbar() {
        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }

    private void getCurrentLocation() {
        //initialize task location
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                //when success
                if (location != null) {
                    //Sync map
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            //initialise lat lng
                            LatLng latLng = new LatLng(location.getLatitude(),
                                    location.getLongitude());
                            //create marker options
                            MarkerOptions options = new MarkerOptions().position(latLng)
                                    .title("You are here");
                            //Zoom map
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                            //Add maker on map
                            googleMap.addMarker(options);
                        }
                    });
                }
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 44) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //When permission granted
                //call method
                getCurrentLocation();
            }
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng tirol = new LatLng(47.259659, 11.400375);
        mMap.addMarker(new MarkerOptions().position(tirol).title("Derzeit 1245 Aktive Fälle")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_announcement_24)));
        LatLng wien = new LatLng(48.210033, 	16.363449);
        mMap.addMarker(new MarkerOptions().position(wien).title("Derzeit 8320 Aktive Fälle")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_announcement_24)));
        LatLng salzburg = new LatLng(47.811195, 13.033229);
        mMap.addMarker(new MarkerOptions().position(salzburg).title("Derzeit 1613 Aktive Fälle")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_announcement_24)));
        LatLng niederoesterreich = new LatLng(48.2000, 15.6167);
        mMap.addMarker(new MarkerOptions().position(niederoesterreich).title("Derzeit 5225 Aktive Fälle")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_announcement_24)));
        LatLng steiermark = new LatLng(47.359344, 14.469983);
        mMap.addMarker(new MarkerOptions().position(steiermark).title("Derzeit 3093 Aktive Fälle")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_announcement_24)));
        LatLng burgenland = new LatLng(47.8456, 	16.5189);
        mMap.addMarker(new MarkerOptions().position(burgenland).title("Derzeit 8362 Aktive Fälle")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_announcement_24)));
        LatLng oberoesterreich = new LatLng(48.3000, 14.2833);
        mMap.addMarker(new MarkerOptions().position(oberoesterreich).title("Derzeit 3723 Aktive Fälle")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_announcement_24)));
        LatLng kaernten = new LatLng(46.6167, 14.3000);
        mMap.addMarker(new MarkerOptions().position(kaernten).title("Derzeit 2126 Aktive Fälle")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_announcement_24)));
        LatLng vorarlberg = new LatLng(47.5050, 9.7492);
        mMap.addMarker(new MarkerOptions().position(vorarlberg).title("Derzeit 4854 Aktive Fälle")
                .icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_baseline_announcement_24)));
    }
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0,0,vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}