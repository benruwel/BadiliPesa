
package com.moringa.mambopesa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("code_n")
    @Expose
    private String codeN;
    @SerializedName("subunit")
    @Expose
    private String subunit;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("bank")
    @Expose
    private String bank;
    @SerializedName("banknotes")
    @Expose
    private String banknotes;
    @SerializedName("coins")
    @Expose
    private String coins;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("symbol_2")
    @Expose
    private String symbol2;
    @SerializedName("banknotes_2")
    @Expose
    private String banknotes2;
    @SerializedName("coins_2")
    @Expose
    private String coins2;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Response() {
    }

    /**
     * 
     * @param country
     * @param symbol
     * @param website
     * @param banknotes2
     * @param coins
     * @param codeN
     * @param icon
     * @param subunit
     * @param type
     * @param coins2
     * @param banknotes
     * @param symbol2
     * @param bank
     * @param name
     * @param shortName
     */
    public Response(String shortName, String name, String country, String codeN, String subunit, String website, String symbol, String bank, String banknotes, String coins, String icon, String type, String symbol2, String banknotes2, String coins2) {
        super();
        this.shortName = shortName;
        this.name = name;
        this.country = country;
        this.codeN = codeN;
        this.subunit = subunit;
        this.website = website;
        this.symbol = symbol;
        this.bank = bank;
        this.banknotes = banknotes;
        this.coins = coins;
        this.icon = icon;
        this.type = type;
        this.symbol2 = symbol2;
        this.banknotes2 = banknotes2;
        this.coins2 = coins2;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCodeN() {
        return codeN;
    }

    public void setCodeN(String codeN) {
        this.codeN = codeN;
    }

    public String getSubunit() {
        return subunit;
    }

    public void setSubunit(String subunit) {
        this.subunit = subunit;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBanknotes() {
        return banknotes;
    }

    public void setBanknotes(String banknotes) {
        this.banknotes = banknotes;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymbol2() {
        return symbol2;
    }

    public void setSymbol2(String symbol2) {
        this.symbol2 = symbol2;
    }

    public String getBanknotes2() {
        return banknotes2;
    }

    public void setBanknotes2(String banknotes2) {
        this.banknotes2 = banknotes2;
    }

    public String getCoins2() {
        return coins2;
    }

    public void setCoins2(String coins2) {
        this.coins2 = coins2;
    }

}
