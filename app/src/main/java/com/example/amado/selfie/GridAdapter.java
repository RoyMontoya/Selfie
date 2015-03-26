package com.example.amado.selfie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Amado on 22/03/2015.
 */
public class GridAdapter extends BaseAdapter{

    private Context mContext;

    public GridAdapter(Context c) {
        mContext = c;

    }

    public int getCount() {
        return sPictures.size();
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
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(250, 275));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(4, 4, 4, 4);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap((Bitmap) sPictures.get(position));
        return imageView;
    }

    // references to our images
    public static ArrayList sPictures = new ArrayList();

      public void startedPictures(){
          Resources res = mContext.getApplicationContext().getResources();
        sPictures.add(BitmapFactory.decodeResource(res, R.drawable.kcself));
        sPictures.add(BitmapFactory.decodeResource(res, R.drawable.arcadialibre));
        sPictures.add(BitmapFactory.decodeResource(res, R.drawable.doge));

    }
      /* R.drawable.doge, R.drawable.arcadialibre, R.drawable.kcself*/



}
