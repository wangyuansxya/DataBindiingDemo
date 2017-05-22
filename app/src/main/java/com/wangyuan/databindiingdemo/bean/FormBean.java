package com.wangyuan.databindiingdemo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wangyuan.databindiingdemo.BR;

/**
 * Created by wangyuan on 2017/5/11.
 */

public class FormBean extends BaseObservable {
    public String name;
    public String password;
    public String thirdName;

    @Bindable
    public String getName() {
        return name;
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
