package com.example.Practice.utills;

import java.util.List;

public class ResponseWrapper<T> {

    private int statusCode;
    private String statusMessage;
    private List<T> data;

    public ResponseWrapper(int statusCode, String statusMessage, List<T> data) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }



    public List<T> getData() {
        return data;
    }
}
