package com.example.viajeroseguro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapsActivity extends AppCompatActivity  implements GoogleMap.OnInfoWindowClickListener,GoogleMap.OnMarkerDragListener, OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker Markerprueba, markerDrag, InfoWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
       LatLng appl = new LatLng(4.620916294826586, -74.1142353423926);
        mMap.addMarker(new MarkerOptions().position(appl).title("Bogotá").snippet("Colombia"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(appl));

     /* LatLng appl = new LatLng(4.620916294826586, -74.1142353423926);
        Markerprueba2 = googleMap.addMarker(new MarkerOptions()
        .position(appl)
        .title("Bogotá")
        .snippet("Colombia")
        .draggable(true)
        );
*/

        LatLng prueba1 = new LatLng(3.4517923, -76.5324943);
        markerDrag = googleMap.addMarker(new MarkerOptions()
                .position(prueba1)
                .title("Cali")
                .snippet("Colombia")
                .draggable(true)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        );

        LatLng cal = new LatLng(6.2443382, -75.573553);
        InfoWindow = googleMap.addMarker(new MarkerOptions()
                .position(cal)
                .title("Medellin")
                .snippet("Colombia")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        );


        /*
        CAMARA
         */

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(appl,7));
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMarkerDragListener(this);
        googleMap.setOnInfoWindowClickListener(this);



    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if(marker.equals(Markerprueba))
        {
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + "," + lng, Toast.LENGTH_SHORT).show();

        }

        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

        if(marker.equals(markerDrag))
        {
            Toast.makeText(this,"Start",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onMarkerDrag(Marker marker) {

        if(marker.equals(markerDrag))
        {
            String newTitle = String.format(Locale.getDefault(),
                    getString(R.string.marker_detail_lating),
                    marker.getPosition().latitude,
                    marker.getPosition().longitude);

            setTitle(newTitle);

        }

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

        if(marker.equals(markerDrag))
        {
            Toast.makeText(this,"Finish",Toast.LENGTH_LONG).show();
            setTitle(R.string.title_activity_maps);
        }

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        if(marker.equals(InfoWindow))
        {
            Calidialog.newInstance(marker.getTitle(),
                    getString(R.string.cali_info))
                    .show(getSupportFragmentManager(),null);
        }


    }
}
