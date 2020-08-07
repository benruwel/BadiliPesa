package com.moringa.badilipesa.network;

import com.moringa.badilipesa.util.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CurrencyExClient {

    private static Retrofit retrofit = null;

    public static CurrencyExApi getClient() {

        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.CURENCYEX_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(CurrencyExApi.class);
    }
}
