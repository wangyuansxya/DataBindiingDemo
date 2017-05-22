package com.wangyuan.databindiingdemo.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.wangyuan.databindiingdemo.R;
import com.wangyuan.databindiingdemo.bean.FormBean;

/**
 * Created by wangyuan on 2017/5/11.
 * 双向绑定
 */
public class TwoWayBindingActivity extends AppCompatActivity {
    //mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTwowayBindingBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_twoway_binding);
        FormBean f = new FormBean();
        f.name = "aaaa";
        f.password = "1233213";
        f.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Toast.makeText(getApplicationContext(), "当前位置" + i, Toast.LENGTH_SHORT).show();
            }
        });
        mBinding.setForm(f);
    }
}
