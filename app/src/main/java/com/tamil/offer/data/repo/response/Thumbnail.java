
package com.tamil.offer.data.repo.response;

import com.google.gson.annotations.Expose;

public class Thumbnail {

    @Expose
    private String hires;
    @Expose
    private String lowres;

    public String getHires() {
        return hires;
    }

    public void setHires(String hires) {
        this.hires = hires;
    }

    public String getLowres() {
        return lowres;
    }

    public void setLowres(String lowres) {
        this.lowres = lowres;
    }

}
