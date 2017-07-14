package com.bignerdranch.android.beatbox;

import android.databinding.BaseObservable;

/**
 * Created by Administrator on 2017/7/13.
 */

public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private BeatBox mBeatBox;
    public SoundViewModel(BeatBox beatBox){
        mBeatBox = beatBox;
    }
    public String getTitle(){
        return mSound.getName();
    }
    public Sound getSound(){
        return mSound;
    }

    public void setSound(Sound sound) {
        mSound = sound;
        notifyChange();
    }

    public void onButtonClicked() {
        mBeatBox.play(mSound);
    }
}
