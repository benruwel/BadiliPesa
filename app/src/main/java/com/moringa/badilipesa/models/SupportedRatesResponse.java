package com.moringa.badilipesa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;
import java.util.Map;

@Parcel
public class SupportedRatesResponse {

    @SerializedName("mCurerncies")
    @Expose
    private Map<String, Currency> mCurerncies;

    /**
     * No args constructor for use in serialization
     *
     */
    public SupportedRatesResponse() {
    }

    public SupportedRatesResponse(Map<String, Currency> currencies) {
        this.mCurerncies = currencies;
    }

    public Map<String, Currency> getCurerncies() {
        return mCurerncies;
    }

    public void setCurerncies(Map<String, Currency> currencies) {
        this.mCurerncies = currencies;
    }
}
