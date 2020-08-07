package com.moringa.badilipesa.models;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Currency {

    private String name;
    private List<Country> countries = null;
    private String symbol;
    /**
     * No args constructor for use in serialization
     *
     */
    public Currency() {
    }

    public Currency(String name, List<Country> countries, String symbol){
        super();
        this.name = name;
        this.countries = countries;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
