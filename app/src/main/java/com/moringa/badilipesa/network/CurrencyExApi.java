package com.moringa.badilipesa.network;

import com.moringa.badilipesa.models.SupportedRatesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrencyExApi {

    //define your api operations here
    @GET("rates")
    Call<SupportedRatesResponse> getCurrencies(
            //specify the source currency
            @Query("source") String source
            //specify the source currency
            //@Query("target") String target
    );

}
