package com.maxime_pc.esilv.youtubeesilv.adaptater;


import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.maxime_pc.esilv.youtubeesilv.DownloadIMG;
import com.maxime_pc.esilv.youtubeesilv.R;
import com.maxime_pc.esilv.youtubeesilv.Result;
import com.maxime_pc.esilv.youtubeesilv.objects.YoutubeVideoViewHolder;

import java.util.List;

/**
 * Created by maxime_PC on 22/03/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<YoutubeVideoViewHolder> {
    private final List<Result> mDataset;


    public MyAdapter(List<Result> myDataset) {
        mDataset = myDataset;
    }


    @Override
    public YoutubeVideoViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.videoyoutube, parent, false);

        YoutubeVideoViewHolder vh = new YoutubeVideoViewHolder(v);

        return vh;
    }


    @Override
    public void onBindViewHolder(YoutubeVideoViewHolder holder, int position) {


        Result result = this.mDataset.get(position);
        holder.title.setText(result.snippet.title);
        holder.description.setText(result.snippet.description);
        new DownloadIMG(holder.image).execute(result.snippet.thumbnails.get("default").url);
        System.out.println(result.snippet.thumbnails.get("default").url);
        System.out.println(result.id.get("videoId"));

    }

    public Result getItem(int position){
        return mDataset.get(position);
    }


    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }
}