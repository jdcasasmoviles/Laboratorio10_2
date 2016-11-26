package com.jdcasas.lab_10_2;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    private CameraUpdate mCamera;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setUpMapIfNeeded();

        setMarker(new LatLng(-12.017128, -77.050748), "Cafetería",
                "El mejor café", 0.9F, 0.1F, 0.1F, R.drawable.cafeteria);
        setMarker(new LatLng(-12.017124, -77.050744), "Restaurante",
                "Ají de gallina buenaso", 0.5F, 0.5F, 0.5F, R.drawable.restaurante);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MenuOpcion1:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case R.id.MenuOpcion2:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case R.id.MenuOpcion3:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;
            case R.id.MenuOpcion4:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap == null) {
            mMap = ((SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map)).getMap();
            if (mMap != null) {
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                mMap.setMyLocationEnabled(true);
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                setUpMap();
            }
        }
    }

    private void setUpMap() {
       /* mMap.addMarker(new MarkerOptions().position(new LatLng(-12.017124,
                -77.050744)).title("Facultad de Ciencias"));

        mCamera = CameraUpdateFactory.newLatLngZoom(new LatLng(
                -12.017124, -77.050744), 0);
        mMap.animateCamera(mCamera);*/

      /*  mMap.addMarker(new MarkerOptions().position(new LatLng(-12.017124,
                -77.050744)).title("Facultad de Ciencias")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cafeteria))
                .snippet("The beast School"));*/
      /* Polygon recta = mMap.addPolygon(new PolygonOptions()
                        .add(new LatLng(-12.019280, -77.050179), new LatLng(-12.019009, -77.049469))
                        .strokeColor(Color.CYAN));

        Polygon cuadrilatero = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(-12.022247, -77.052253), new LatLng(-12.021103, -77.051813)
                        , new LatLng(-12.019592, -77.052231),new LatLng(-12.019508, -77.054184),
                         new LatLng(-12.022247, -77.052253))
                .strokeColor(Color.GREEN).fillColor(Color.WHITE));

        CameraPosition cameraPosition =
                new CameraPosition.Builder() .target(new LatLng(-12.017124, -77.050744))
                        .bearing(45)
                        .tilt(60)
                        .zoom(14)
                        .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));*/
       /* mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override public boolean onMarkerClick(Marker marker) {
                Toast.makeText(MainActivity.this, "Marcador setOnMarkerClickListener:\n" +
                        marker.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            public void onCameraChange(CameraPosition position) {
                Toast.makeText(MainActivity.this, "setOnCameraChangeListener" +
                        "\nNueva Vista de camara\n" +
                        "Latitud: " + position.target.latitude +
                        "\n" + "Longitud: " + position.target.longitude +
                        "\n" + "Zoom: " + position.zoom + "\n" +
                        "Orientación: " + position.bearing + "\n" +
                        "Ángulo: " + position.tilt, Toast.LENGTH_SHORT).show();
            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            public void onMapLongClick(LatLng point) {
                Projection proj = mMap.getProjection();
                Point coord = proj.toScreenLocation(point);
                Toast.makeText(MainActivity.this, "setOnMapLongClickListener" +
                        "\nClick largo\n" +
                        "Lat: " + point.latitude + "\n" + "Lng: " +
                        point.longitude + "\n" + "X: " + coord.x +
                        " - Y: " + coord.y, Toast.LENGTH_SHORT).show();
            }
        });*/

        mCamera = CameraUpdateFactory.newLatLngZoom(new LatLng(
                -12.017124, -77.050744), 14);
        mMap.animateCamera(mCamera);
    }

    private void setMarker(LatLng position, String title, String info,
                           float opacity, float dimension1, float dimension2, int icon){
        mMap.addMarker(new MarkerOptions()
                .position(position)
                .title(title)
                .snippet(info)
                .alpha(opacity)
                .anchor(dimension1, dimension2)
                .icon(BitmapDescriptorFactory.fromResource(icon)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
