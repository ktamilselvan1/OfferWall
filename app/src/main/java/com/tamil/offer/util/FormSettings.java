package com.tamil.offer.util;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class FormSettings {

    private final SharedPreferences sharedPreferences;

    @Inject
    public FormSettings(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public String getApplicationID() {
        return this.sharedPreferences.getString("applicationID", "2070");
    }

    public void setApplicationID(String applicationID) {
        this.sharedPreferences.edit().putString("applicationID", applicationID).apply();
    }

    public String getUserID() {
        return this.sharedPreferences.getString("userID", "superman");
    }

    public void setUserID(String userID) {
        this.sharedPreferences.edit().putString("userID", userID).apply();
    }

    public String getToken() {
        return this.sharedPreferences.getString("token", "1c915e3b5d42d05136185030892fbb846c278927");
    }

    public void setToken(String token) {
        this.sharedPreferences.edit().putString("token", token).apply();
    }
}
