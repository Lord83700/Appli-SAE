package com.example.applisae;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GetAPI {
    private static final String BASE_URL = "https://api.example.com/"; // Remplace avec l'URL de ton API

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static ApiService getApiService() {
        return getClient().create(ApiService.class);
    }
}
