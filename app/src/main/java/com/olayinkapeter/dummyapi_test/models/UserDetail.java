package com.olayinkapeter.dummyapi_test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class UserDetail {
    @SerializedName("id")
    @Expose
    private String userID;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("picture")
    @Expose
    private String picture;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;

    @SerializedName("registerDate")
    @Expose
    private String registerDate;

    public UserDetail(String userID, String phone, String title, String firstName, String lastName,
                      String email, String picture, String gender, String dateOfBirth, String registerDate) {
        this.userID = userID;
        this.phone = phone;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.picture = picture;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.registerDate = registerDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPhone() {
        return "Phone: " + phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title.substring(0, 1).toUpperCase() + title.substring(1);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender.substring(0, 1).toUpperCase() + gender.substring(1);
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
            OffsetDateTime dateOfBirthTime = OffsetDateTime.parse(dateOfBirth, formatter);
            dateOfBirth = String.valueOf(dateOfBirthTime.getMonth()) + " " + String.valueOf(dateOfBirthTime.getYear());
        }
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegisterDate() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
            OffsetDateTime dateOfBirthTime = OffsetDateTime.parse(registerDate, formatter);
            registerDate = String.valueOf(dateOfBirthTime.getMonth()) + " " + String.valueOf(dateOfBirthTime.getYear());
        }
        return "Registered in " + registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
}
