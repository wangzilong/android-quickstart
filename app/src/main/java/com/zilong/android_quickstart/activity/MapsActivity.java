package com.zilong.android_quickstart.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.zilong.android_quickstart.R;
import com.zilong.android_quickstart.mock.PlaceMock;
import com.zilong.android_quickstart.model.Place;
import com.zilong.android_quickstart.viewModel.MapGoogleViewModel;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private final static int DEFAULT_ZOOM = 12;
    public final static LatLng CAMERA_LAT_LNG = new LatLng(52.0293775, -0.8071433);
    private LatLng cameraLatLng = CAMERA_LAT_LNG;

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
        initViewModel();
    }

    private void initViewModel(){
        vm = new MapGoogleViewModel();
        vm.setPlaces(PlaceMock.PLACES);
        onChangedViewModel();
    }

    private void onChangedViewModel(){
        for (Place place : vm.getPlaces()) {
            mMap.addMarker(buildMarker(place));
        }
        if (!vm.getPlaces().isEmpty()){
            cameraLatLng = buildLatLng(vm.getPlaces().get(0));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cameraLatLng, DEFAULT_ZOOM));
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
