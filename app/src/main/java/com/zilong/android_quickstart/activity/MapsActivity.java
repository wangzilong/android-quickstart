package com.zilong.android_quickstart.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.*;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.zilong.android_quickstart.R;
import com.zilong.android_quickstart.mock.PlaceMock;
import com.zilong.android_quickstart.model.Place;
import com.zilong.android_quickstart.viewModel.MapGoogleViewModel;

public class MapsActivity extends FragmentActivity implements OnCameraIdleListener, OnMapReadyCallback {

    private MapGoogleViewModel vm;

    private GoogleMap mMap;

    /**
     * 1. Init UI.
     *   1.1 if LatLng in bundle, update default location.
     * 2. async query places
     * 3. show places in map
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        onCreateView();
    }

    private void onCreateView(){
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //init Actions button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.map_actions);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSearchBtn();
            }
        });
    }


    private void onClickSearchBtn(){
        disableSearchHereBtn();
        vm.setLatLng(mMap.getCameraPosition().target);
        vm.setZoom((int) mMap.getCameraPosition().zoom);
        onChangedViewModel();
        Toast.makeText(this, "Camera Location:"+ vm.getLatLng().toString(), Toast.LENGTH_SHORT).show();
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
        mMap.setOnCameraIdleListener(this);
        initViewModel();
    }


    @Override
    public void onCameraIdle() {
        enableSearchHereBtn();
    }

    private void enableSearchHereBtn(){
        Toast.makeText(this, "Enable Search Button.", Toast.LENGTH_SHORT).show();
    }

    private void disableSearchHereBtn(){
        Toast.makeText(this, "Disable Search Button.", Toast.LENGTH_SHORT).show();
    }

    private void initViewModel(){
        if (vm == null)
            vm = new MapGoogleViewModel();
        onChangedViewModel();
    }

    private void onChangedViewModel(){
        //mock data
        vm.setPlaces(PlaceMock.PLACES);

        for (Place place : vm.getPlaces()) {
            mMap.addMarker(buildMarker(place));
        }
        if (!vm.getPlaces().isEmpty()){
            vm.setLatLng(buildLatLng(vm.getPlaces().get(0)));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vm.getLatLng(), vm.getZoom()));
    }

    private MarkerOptions buildMarker(Place place){
        return new MarkerOptions()
                .position(buildLatLng(place))
                .title(place.getName())
                .snippet(place.getDescription());
    }

    private LatLng buildLatLng(Place place){
        return new LatLng(place.getLatitude(), place.getLongitude());
    }

}
