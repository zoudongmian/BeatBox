package com.bignerdranch.android.beatbox;

/**
 * Created by Administrator on 2017/7/13.
 */

public class Sound {
    private String mAssetPath;
    private String mName;
    private Integer mSoundId;
    public Sound(String assetPath){
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length - 1];
        mName = filename.replace(".mp3","");
    }

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }

    public String getName() {
        return mName;
    }

    public String getAssetPath() {
        return mAssetPath;
    }
}//创建Sound对象
