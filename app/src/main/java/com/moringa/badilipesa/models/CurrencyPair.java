package com.moringa.badilipesa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class CurrencyPair {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("change")
    @Expose
    private String change;
    @SerializedName("chg_per")
    @Expose
    private String chgPer;
    @SerializedName("last_changed")
    @Expose
    private String lastChanged;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("symbol")
    @Expose
    private String symbol;

    /**
     * No args constructor for use in serialization
     *
     */
    public CurrencyPair() {
    }

    /**
     *
     * @param symbol
     * @param chgPer
     * @param price
     * @param change
     * @param lastChanged
     * @param id
     * @param type
     */
    public CurrencyPair(String id, String price, String change, String chgPer, String lastChanged, String type, String symbol) {
        super();
        this.id = id;
        this.price = price;
        this.change = change;
        this.chgPer = chgPer;
        this.lastChanged = lastChanged;
        this.type = type;
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChgPer() {
        return chgPer;
    }

    public void setChgPer(String chgPer) {
        this.chgPer = chgPer;
    }

    public String getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(String lastChanged) {
        this.lastChanged = lastChanged;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}