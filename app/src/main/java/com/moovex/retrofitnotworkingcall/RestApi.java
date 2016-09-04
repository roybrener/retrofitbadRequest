package com.moovex.retrofitnotworkingcall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by roy on 9/4/2016.
 */
public interface RestApi {

    @GET("/ride.asp")
    Call<List<Model>> getData (@Query("userid") int userId,
                                  @Query("from_name") String fromName,
                                  @Query("from_lat") double lat,
                                  @Query("from_lng") double lng,
                                  @Query("to_name") String toName,
                                  @Query("to_lat") double toLat,
                                  @Query("to_lng") double toLng,
                                  @Query("time") long time);
}
