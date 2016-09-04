package com.moovex.retrofitnotworkingcall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final RestApi restApi = RestClient.getRestClient().getRestApi();

        final Call<List<Model>> call = restApi.getData(1, "Location", 40.641311, -73.778139, "OtherLocation", 43.0730517, -89.401230, new Date().getTime());

        call.enqueue(
                new Callback<List<Model>>() {
                    @Override
                    public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                        Log.w(TAG, "onResponse: Success");
                    }

                    @Override
                    public void onFailure(Call<List<Model>> call, Throwable t) {
                        Log.w(TAG, "onFailure: error", t);
                    }
                }
        );
    }
}
