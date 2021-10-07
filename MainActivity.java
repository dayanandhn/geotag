package com.example.splitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    MapView mapView ;
    GoogleMap gmap;
    MediaController mediaControls;
    VideoView videoView;
    Button button;
    float lat = (float) 40.71;
    float lan = (float) -74.00;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.video);
        button = findViewById(R.id.button);
        videoView.setVideoPath("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4");

        videoView.start();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_view);
        mapFragment.getMapAsync(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lat+=(float)(0.01);lan+=(float)(0.01);
                LatLng ny = new LatLng(lat,lan);
                gmap.moveCamera(CameraUpdateFactory.newLatLng(ny));
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        gmap = googleMap;
        gmap.setMinZoomPreference(12);
        LatLng ny = new LatLng(lat,lan);
        gmap.moveCamera(CameraUpdateFactory.newLatLng(ny));
    }

}