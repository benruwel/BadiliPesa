package com.moringa.mambopesa.network;

import com.moringa.mambopesa.util.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//used to make network requests to the API
public class CurrencyExClient {

    private static Retrofit retrofit = null;

    public static CurrencyExApi getClient() {

        //Singleton Pattern - ensures one Retrofit instance is created for the life of the program
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.FOREX_BASE_URL) //used to append the endpoints that we define in the network interface
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create()) //enables serialization of JSON objects to our models' objects
                    .build();
        }

        return retrofit.create(CurrencyExApi.class);
    }
}
