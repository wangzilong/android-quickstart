package com.zilong.android_quickstart.viewModel;

import com.google.android.gms.maps.model.LatLng;
import com.zilong.android_quickstart.model.Place;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MapGoogleViewModel implements Serializable {

    private final static int DEFAULT_ZOOM = 12;
    public final static LatLng CAMERA_LAT_LNG = new LatLng(52.0293775, -0.8071433);

    private LatLng latLng = CAMERA_LAT_LNG;

    private int zoom = DEFAULT_ZOOM;

    private Place selectedPlace;

    private List<Place> places = new ArrayList<>();

    public MapGoogleViewModel() {
    }

    public Place getSelectedPlace() {
        return selectedPlace;
    }

    public void setSelectedPlace(Place selectedPlace) {
        this.selectedPlace = selectedPlace;
    }

    public List<Place> getPlaces() {
        return places == null ? Collections.<Place>emptyList() : places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }
}
