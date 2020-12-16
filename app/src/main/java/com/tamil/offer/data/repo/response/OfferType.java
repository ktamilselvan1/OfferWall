
package com.tamil.offer.data.repo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OfferType {

    @SerializedName("offer_type_id")
    private Long offerTypeId;
    @Expose
    private String readable;

    public Long getOfferTypeId() {
        return offerTypeId;
    }

    public void setOfferTypeId(Long offerTypeId) {
        this.offerTypeId = offerTypeId;
    }

    public String getReadable() {
        return readable;
    }

    public void setReadable(String readable) {
        this.readable = readable;
    }

}
