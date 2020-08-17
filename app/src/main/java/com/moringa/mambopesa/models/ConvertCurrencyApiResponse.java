package com.moringa.mambopesa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class ConvertCurrencyApiResponse {

    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("rates")
    @Expose
    private Rates rates;

    /**
     * No args constructor for use in serialization
     *
     */
    public ConvertCurrencyApiResponse() {
    }

    /**
     *
     * @param date
     * @param amount
     * @param rates
     * @param base
     */
    public ConvertCurrencyApiResponse(Double amount, String base, String date, Rates rates) {
        super();
        this.amount = amount;
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

}
