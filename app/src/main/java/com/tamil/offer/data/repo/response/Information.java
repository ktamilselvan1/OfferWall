
package com.tamil.offer.data.repo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Information {

    @SerializedName("app_name")
    private String appName;
    @Expose
    private Long appid;
    @Expose
    private String country;
    @Expose
    private String language;
    @SerializedName("support_url")
    private String supportUrl;
    @SerializedName("virtual_currency")
    private String virtualCurrency;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSupportUrl() {
        return supportUrl;
    }

    public void setSupportUrl(String supportUrl) {
        this.supportUrl = supportUrl;
    }

    public String getVirtualCurrency() {
        return virtualCurrency;
    }

    public void setVirtualCurrency(String virtualCurrency) {
        this.virtualCurrency = virtualCurrency;
    }

}
