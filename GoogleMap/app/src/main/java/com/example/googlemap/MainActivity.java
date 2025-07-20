package com.example.googlemap;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Example: Add marker in Kathmandu and move camera
        LatLng kathmandu = new LatLng(27.7172, 85.3240);
        mMap.addMarker(new MarkerOptions().position(kathmandu).title("Marker in Kathmandu"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kathmandu, 12));
    }
}
