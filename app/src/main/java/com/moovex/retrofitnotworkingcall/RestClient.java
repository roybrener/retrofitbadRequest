package com.moovex.retrofitnotworkingcall;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by roy on 9/4/2016.
 */

public class RestClient {

    public static final String BASE_URL = "http://denver.moovex.net/";

    private static RestClient restClient;
    private Retrofit retrofit;


    private RestApi restApi;


    public static RestClient getRestClient() {
        if (restClient != null) {
            return restClient;
        }

        synchronized (RestClient.class) {
            if (restClient == null) {
                final OkHttpClient.Builder builder = new OkHttpClient.Builder();
                builder.followRedirects(true);

                final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(loggingInterceptor);

                builder.connectTimeout(360, TimeUnit.SECONDS);
                builder.readTimeout(360, TimeUnit.SECONDS);

                Gson gson = new GsonBuilder().setLenient().create();
                RestClient client = new RestClient();
                client.retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(builder.build())
                        .build();
                client.restApi = client.retrofit.create(RestApi.class);

                restClient = client;
            }
        }

        return restClient;
    }

    public RestApi getRestApi() {
        return restApi;
    }
}
