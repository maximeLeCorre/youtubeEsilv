package com.maxime_pc.esilv.youtubeesilv.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import com.maxime_pc.esilv.youtubeesilv.R;

import com.maxime_pc.esilv.youtubeesilv.YoutubeAPI;
import com.maxime_pc.esilv.youtubeesilv.adaptater.MyAdapter;
import com.maxime_pc.esilv.youtubeesilv.objects.YoutubeVideoResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    final int MAX_RESULT =25;
    final String PART =  "snippet";
    public static final String API_KEY = "AIzaSyD3LUad66NkJwbECKXENg_hGpBe5YZ9uIY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutManager = new LinearLayoutManager(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/youtube/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recyclerView = (RecyclerView) findViewById(R.id.videoList);

        final YoutubeAPI service = retrofit.create(YoutubeAPI.class);

        final Button button = findViewById(R.id.buttonResearch);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setLayoutManager(layoutManager);
                EditText search = findViewById(R.id.research);
                String q = search.getText().toString();
                Call<YoutubeVideoResult> videos = service.searchFor(API_KEY,PART,q,MAX_RESULT);
                videos.enqueue(new Callback<YoutubeVideoResult>() {
                    @Override
                    public void onResponse(Call<YoutubeVideoResult> call, Response<YoutubeVideoResult> response) {

                        adapter = new MyAdapter(response.body().items);

                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<YoutubeVideoResult> call, Throwable t) {
                        Log.i("debug",t.toString());
                    }
                });


            }
        });

    }

}
