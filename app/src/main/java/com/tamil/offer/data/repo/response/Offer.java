
package com.tamil.offer.data.repo.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {

    @Expose
    private String link;
    @SerializedName("offer_id")
    private Long offerId;
    @SerializedName("offer_types")
    private List<OfferType> offerTypes;
    @Expose
    private Long payout;
    @SerializedName("required_actions")
    private String requiredActions;
    @Expose
    private String teaser;
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("time_to_payout")
    private TimeToPayout timeToPayout;
    @Expose
    private String title;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public List<OfferType> getOfferTypes() {
        return offerTypes;
    }

    public void setOfferTypes(List<OfferType> offerTypes) {
        this.offerTypes = offerTypes;
    }

    public Long getPayout() {
        return payout;
    }

    public void setPayout(Long payout) {
        this.payout = payout;
    }

    public String getRequiredActions() {
        return requiredActions;
    }

    public void setRequiredActions(String requiredActions) {
        this.requiredActions = requiredActions;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public TimeToPayout getTimeToPayout() {
        return timeToPayout;
    }

    public void setTimeToPayout(TimeToPayout timeToPayout) {
        this.timeToPayout = timeToPayout;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
