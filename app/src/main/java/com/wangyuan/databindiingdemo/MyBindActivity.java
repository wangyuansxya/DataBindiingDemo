package com.wangyuan.databindiingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wangyuan.databindiingdemo.bean.MessageBean;
import com.wangyuan.databindiingdemo.databinding.ActivityBindMyBinding;

/**
 * Created by wangyuan on 2017/5/11.
 */

public class MyBindActivity extends AppCompatActivity {
    private ActivityBindMyBinding mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MessageBean msg = new MessageBean();
        msg.isRed = true;
        msg.imageUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494489704090&di=3911fc42ca02cb97b84c670b88f7eae7&imgtype=0&src=http%3A%2F%2Fimg.duoziwang.com%2F2017%2F04%2F15%2FB1282.jpg";
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_bind_my);
        mBinding.setMsg(msg);
    }
}
