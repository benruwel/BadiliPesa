
package com.moringa.mambopesa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Info {

    @SerializedName("server_time")
    @Expose
    private String serverTime;
    @SerializedName("credit_count")
    @Expose
    private Integer creditCount;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Info() {
    }

    /**
     * 
     * @param creditCount
     * @param serverTime
     */
    public Info(String serverTime, Integer creditCount) {
        super();
        this.serverTime = serverTime;
        this.creditCount = creditCount;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public Integer getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(Integer creditCount) {
        this.creditCount = creditCount;
    }

}
