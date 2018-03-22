package com.maxime_pc.esilv.youtubeesilv;

/**
 * Created by maxime_PC on 22/03/2018.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Async download of Bitmat from URL
 * From https://stackoverflow.com/questions/2471935/how-to-load-an-imageview-by-url-in-android
 */

public class DownloadIMG extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public DownloadIMG(ImageView bmImage) { // the imageview where the iamge s supposed to go
        this.bmImage = bmImage;
    }

    public Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}
