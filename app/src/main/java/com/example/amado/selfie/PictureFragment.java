package com.example.amado.selfie;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {
    public static ImageView mImageSelfie;
    public static Selfie mSelfie;

    public static final int CAMARA = 666;

    public PictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_picture, container, false);
        mImageSelfie = (ImageView) v.findViewById(R.id.selfie);
        mImageSelfie.setImageResource(R.drawable.kcself);
        Button selfieButton = (Button) v.findViewById(R.id.selfie_button);

        selfieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                mSelfie = new Selfie();

                i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mSelfie.getFile()));
                startActivityForResult(i, CAMARA);
            }
        });

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mSelfie != null) {
            mImageSelfie.setImageURI(Uri.fromFile(mSelfie.getFile()));
            mImageSelfie.setRotation(90f);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMARA && resultCode == MainActivity.RESULT_OK) {
            mImageSelfie.setImageURI(Uri.fromFile(mSelfie.getFile()));
            GridAdapter.sPictures.add(getImageFromCamera());

        }

    }

    private Bitmap getImageFromCamera() {
        Matrix matrix = new Matrix();
        matrix.postRotate(90f);
        Bitmap bitmap = BitmapFactory.decodeFile(mSelfie.getFile().getAbsolutePath());
        return Bitmap.createBitmap(bitmap, 0, 0 , bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }


}
