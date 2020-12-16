package com.tamil.offer.data.base;

public class BaseResponse {

    private Status status;
    private int errorCode;
    private String errorMessage;

    public BaseResponse(Status status, int errorCode, String errorMessage) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
