package com.zilong.android_quickstart.viewModel;

import com.zilong.android_quickstart.model.Place;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MapGoogleViewModel {

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
}
