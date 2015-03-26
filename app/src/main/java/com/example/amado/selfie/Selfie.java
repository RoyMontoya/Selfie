package com.example.amado.selfie;

import android.os.Environment;

import java.io.File;
import java.util.UUID;

/**
 * Created by Amado on 25/03/2015.
 */
public class Selfie {
    private UUID mID;
    private static final File sDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

    public Selfie() {
        mID = UUID.randomUUID();
    }

    public UUID getID() {
        return mID;
    }

    public File getFile(){
        return new File(sDirectory, mID.toString());
    }
}
