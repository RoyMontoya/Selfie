package com.example.amado.selfie;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

import java.io.File;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;


public class MainActivity extends ActionBarActivity implements MaterialTabListener{

    private MaterialTabHost mTabHost;
    private PictureFragment mPictureFragment;
    private PictureCollection mCollection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTabHost = (MaterialTabHost)findViewById(R.id.tabHost);
        mTabHost.addTab(mTabHost.newTab().setText("SELFIE").setTabListener(this));
        mTabHost.addTab(mTabHost.newTab().setText("GALERY").setTabListener(this));


        mPictureFragment = (PictureFragment)getFragmentManager()
                .findFragmentById(R.id.picture_container);
        if(mPictureFragment == null){
            mPictureFragment = new PictureFragment();
            getFragmentManager().beginTransaction().add(R.id.picture_container, mPictureFragment)
                    .commit();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            mPictureFragment = new PictureFragment();
            getFragmentManager().beginTransaction().add(R.id.picture_container, mPictureFragment)
                    .commit();

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(MaterialTab materialTab) {
        mTabHost.setSelectedNavigationItem(materialTab.getPosition());
         switch (materialTab.getPosition()) {
             case 1:
          /*  mCollection = (PictureCollection) getFragmentManager()
                    .findFragmentById(R.id.picture_container);*/
                 if (mCollection == null) {
                     Log.d("MainActivity", "crear coleccion");
                     mCollection = new PictureCollection();
                 }
                     getFragmentManager().beginTransaction().replace(R.id.picture_container, mCollection)
                             .commit();

                 break;
             case 0:
                 if(mPictureFragment == null){
                     mPictureFragment = new PictureFragment();
                 }

                 getFragmentManager().beginTransaction().replace(R.id.picture_container, mPictureFragment)
                         .commit();
         }
    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {

    }
}
