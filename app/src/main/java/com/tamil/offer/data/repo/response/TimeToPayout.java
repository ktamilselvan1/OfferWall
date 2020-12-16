
package com.tamil.offer.data.repo.response;

import com.google.gson.annotations.Expose;

public class TimeToPayout {

    @Expose
    private Long amount;
    @Expose
    private String readable;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getReadable() {
        return readable;
    }

    public void setReadable(String readable) {
        this.readable = readable;
    }

}
