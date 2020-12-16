
package com.tamil.offer.data.repo.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.tamil.offer.data.base.BaseResponse;
import com.tamil.offer.data.base.Status;

public class OfferWallResponse extends BaseResponse {

    @Expose
    private String code;
    @Expose
    private Long count;
    @Expose
    private Information information;
    @Expose
    private String message;
    @Expose
    private List<Offer> offers;
    @Expose
    private Long pages;

    public OfferWallResponse(Status status, int errorCode, String errorMessage) {
        super(status, errorCode, errorMessage);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

}
