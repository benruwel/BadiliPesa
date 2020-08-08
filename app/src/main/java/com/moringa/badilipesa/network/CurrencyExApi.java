package com.moringa.badilipesa.network;

import com.moringa.badilipesa.models.SupportedRatesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrencyExApi {

    //define your api operations here
    //Return all related currencies of required currency
    @GET("cross")
    Call<SupportedRatesResponse> getRelatedCurrencies(
            //specify the source currency symbol such as KES/USD/EUR
            @Query("symbol") String symbol,
            //this api requires the api key to be present in the query params
            @Query("access_key") String access_key
    );

}
