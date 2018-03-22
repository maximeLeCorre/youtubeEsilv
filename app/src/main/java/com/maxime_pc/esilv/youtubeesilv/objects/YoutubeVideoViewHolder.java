package com.maxime_pc.esilv.youtubeesilv.objects;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxime_pc.esilv.youtubeesilv.DownloadIMG;
import com.maxime_pc.esilv.youtubeesilv.R;
import com.maxime_pc.esilv.youtubeesilv.Result;


/**
 * Created by maxime_PC on 22/03/2018.
 */

public class YoutubeVideoViewHolder  extends RecyclerView.ViewHolder{

    public TextView title;
    public TextView description;
    public ImageView image;

    public YoutubeVideoViewHolder(View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.titleTextView);
        description = itemView.findViewById(R.id.descriptionTextView);
        image = itemView.findViewById(R.id.image);
    }

}
