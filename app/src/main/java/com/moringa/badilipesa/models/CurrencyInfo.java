package com.moringa.badilipesa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrencyInfo {
    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("rate")
    @Expose
    private Double rate;

    /**
     * No args constructor for use in serialization
     *
     */
    public CurrencyInfo() {
    }

    /**
     *
     * @param rate
     * @param timestamp
     */
    public CurrencyInfo(Integer timestamp, Double rate) {
        super();
        this.timestamp = timestamp;
        this.rate = rate;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
