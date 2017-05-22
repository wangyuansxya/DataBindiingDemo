package com.wangyuan.databindiingdemo.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by wangyuan on 2017/5/10.
 */

public class MyViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private T mDataBinding;

    public MyViewHolder(T dataBinding) {
        super(dataBinding.getRoot());
        this.mDataBinding = dataBinding;
    }

    public ViewDataBinding getBinding() {
        return mDataBinding;
    }
}
