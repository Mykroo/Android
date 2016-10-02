package com.mykro.examen_pokedex;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by mc_mi on 02/10/2016.
 */
private class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return 1;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        File f = new File(R.);
        File[] files = f.listFiles();
        imageView.setImageURI(Uri.parse(Environment.getExternalStorageDirectory()+"/MyDir/"));
        for(int i=0; i<files.length; i++){
            Bitmap bm = BitmapFactory.decodeFile(IMAGE_DIRECTORY + File.separator + files[i].getName());

            imageView.setImageBitmap(extractThumbnail(bm, 10, 10));

        }
        return imageView;
    }
}