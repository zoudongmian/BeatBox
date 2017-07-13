package com.bignerdranch.android.beatbox;

/**
 * Created by Administrator on 2017/7/13.
 */

public class Sound {
    private String mAssetPath;
    private String mName;
    public Sound(String assetPath){
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length - 1];
        mName = filename.replace(".mp3","");
    }

    public String getName() {
        return mName;
    }

    public String getAssetPath() {
        return mAssetPath;
    }
}
