package com.moringa.mambopesa.network;

import com.moringa.mambopesa.models.ConvertCurrencyApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConversionApi {
    //define your api operations here
    //currency conversion is facilitated by providing the variables in the parameters
    @GET("latest")
    Call<ConvertCurrencyApiResponse> getConversionResults(
            //specify the source amount to convert
            @Query("amount") String amount,
            //specify the currency symbol to convert 'from' such as KES/USD/EUR
            @Query("from") String from,
            //specify the currency symbol to convert 'to' such as KES/USD/EUR
            @Query("to") String to
    );
}
