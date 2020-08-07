package com.moringa.badilipesa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class SupportedRatesResponse {

    @SerializedName("mCurerncies")
    @Expose
    private List<Currency> mCurerncies;

    /**
     * No args constructor for use in serialization
     *
     */
    public SupportedRatesResponse() {
    }

    public SupportedRatesResponse(List<Currency> currencies) {
        this.mCurerncies = currencies;
    }

    public List<Currency> getCurerncies() {
        return mCurerncies;
    }

    public void setCurerncies(List<Currency> mCurerncies) {
        this.mCurerncies = mCurerncies;
    }
}
