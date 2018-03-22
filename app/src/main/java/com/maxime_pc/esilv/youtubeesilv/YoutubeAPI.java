package com.maxime_pc.esilv.youtubeesilv;

import com.maxime_pc.esilv.youtubeesilv.objects.YoutubeVideoResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;

/**
 * Created by maxime_PC on 22/03/2018.
 */

public interface YoutubeAPI {
    @GET("search")
    Call<YoutubeVideoResult> searchFor(@Query("key") String api_key,
                                       @Query("part") String part,
                                       @Query("q") String q,
                                       @Query("maxResults") int max_results);
}
