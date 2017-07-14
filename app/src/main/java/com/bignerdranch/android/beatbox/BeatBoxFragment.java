package com.bignerdranch.android.beatbox;

import android.app.FragmentBreadCrumbs;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.beatbox.databinding.FragmentBeatBoxBinding;
import com.bignerdranch.android.beatbox.databinding.ListItemSoundBinding;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */

public class BeatBoxFragment extends Fragment{
    private BeatBox mBeatBox;
    public static BeatBoxFragment newInstance(){
        return new BeatBoxFragment();
    }

    //创建BeatBox实例
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeatBox = new BeatBox(getActivity());
    }

    //实例化绑定类
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        FragmentBeatBoxBinding binding = DataBindingUtil
                .inflate(inflater,R.layout.fragment_beat_box,container,false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));//配置RecyclerView
        binding.recyclerView.setAdapter(new SoundAdapter(mBeatBox.getSounds()));//使用SoundAdapter传入声音资源
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBeatBox.release();
    }

    //创建SoundHolder
    private  class SoundHolder extends RecyclerView.ViewHolder{
        private ListItemSoundBinding mBinding;
        public SoundHolder(ListItemSoundBinding binding) {
            super(binding.getRoot());
            mBinding =binding;
            mBinding.setViewModel(new SoundViewModel(mBeatBox));
        }
        public void bind(Sound sound){
           mBinding.getViewModel().setSound(sound);
            mBinding.executePendingBindings();
        }//关联使用视图模型
    }
    //创建SoundAdapter
    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{
       //绑定Sound列表
        private List<Sound>mSounds;
        public SoundAdapter(List<Sound>sounds){
            mSounds = sounds;
        }

        //
        @Override
        public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            ListItemSoundBinding binding = DataBindingUtil
                    .inflate(inflater,R.layout.list_item_sound,parent,false);
            return new SoundHolder(binding);
        }

        @Override
        public void onBindViewHolder(SoundHolder holder, int position) {
            Sound sound = mSounds.get(position);
            holder.bind(sound);//调用bind方法
        }

        @Override
        public int getItemCount() {
            return mSounds.size();
        }
    }

}
