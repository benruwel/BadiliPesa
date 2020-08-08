package com.moringa.badilipesa.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelatedCurrenciesApiResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("response")
    @Expose
    private List<Response> response = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public RelatedCurrenciesApiResponse() {
    }

    /**
     *
     * @param msg
     * @param code
     * @param response
     * @param status
     */
    public RelatedCurrenciesApiResponse(Boolean status, Integer code, String msg, List<Response> response) {
        super();
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.response = response;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }
}
