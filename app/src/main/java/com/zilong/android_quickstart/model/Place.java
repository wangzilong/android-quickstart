package com.zilong.android_quickstart.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

public class Place {
    public static enum Status{
        CREATED,        // Initialize status, after the place be created
        PROCESSING,     // in reviewing and waiting for approve.
        APPROVED,       // Have be approved
        DECLINED,       // Decline
        DELETING        // A background task is deleting it now.
    }
    protected Long id;
    private Date dateCreated;
    private Date lastUpdated;
    private String name;
    private String description;
    private String address;
    private String address2;
    private String city;
    private String country;
    private String postalCode;
    private String url;
    private Double latitude;
    private Double longitude;
    private Status status;
    private String streetMapUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStreetMapUrl() {
        return streetMapUrl;
    }

    public void setStreetMapUrl(String streetMapUrl) {
        this.streetMapUrl = streetMapUrl;
    }
}
