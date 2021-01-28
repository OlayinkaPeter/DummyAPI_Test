package com.olayinkapeter.dummyapi_test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("street")
    @Expose
    private String street;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("timezone")
    @Expose
    private String timezone;

    @SerializedName("country")
    @Expose
    private String country;

    public Location(String state, String street, String city, String timezone, String country) {
        this.state = state;
        this.street = street;
        this.city = city;
        this.timezone = timezone;
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}