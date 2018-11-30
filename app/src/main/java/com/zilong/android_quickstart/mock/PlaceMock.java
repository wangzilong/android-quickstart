package com.zilong.android_quickstart.mock;

import com.zilong.android_quickstart.model.Place;
import com.zilong.android_quickstart.utils.RandomUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.zilong.android_quickstart.activity.MapsActivity.CAMERA_LAT_LNG;

public class PlaceMock {
    public static List<Place> PLACES = new ArrayList<>();

    private final static double d = 1d;
    static {
        for (int i = 0; i < 100; i++) {
            Place p = new Place();
            p.setName(RandomUtils.chars(8));
            p.setDescription(RandomUtils.chars(16));
            p.setLatitude(RandomUtils.nextDouble(format(CAMERA_LAT_LNG.latitude - d), format(CAMERA_LAT_LNG.latitude + d)));
            p.setLongitude(RandomUtils.nextDouble(format(CAMERA_LAT_LNG.longitude - d), format(CAMERA_LAT_LNG.longitude + d)));
            PLACES.add(p);
        }
    }

    private final static double format(double d){
        return new BigDecimal(d).setScale(6, 1).doubleValue();
    }
}
