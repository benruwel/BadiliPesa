package com.moringa.mambopesa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Rates {
    @SerializedName("convertedAmount")
    @Expose
    private Double convertedAmount;

    /**
     * No args constructor for use in serialization
     *
     */
    public Rates() {
    }

    /**
     *
     * @param convertedAmount
     */
    public Rates(Double convertedAmount) {
        super();
        this.convertedAmount = convertedAmount;
    }

    public Double getConvertedAmount() {
        return convertedAmount;
    }

    public void setUSD(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
}
