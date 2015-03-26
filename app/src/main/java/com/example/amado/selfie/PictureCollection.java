package com.example.amado.selfie;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class PictureCollection extends Fragment {


    private GridAdapter mAdapter;

    public PictureCollection() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v =inflater.inflate(R.layout.fragment_picture_collection, container, false);

        final GridView gridview = (GridView)v.findViewById(R.id.gridview);
        if(mAdapter == null) {
            mAdapter = new GridAdapter(getActivity().getApplicationContext());
            mAdapter.startedPictures();
        }
        gridview.setAdapter(mAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                gridview.getItemAtPosition(position);

            }
        });
        return v;
    }


}
