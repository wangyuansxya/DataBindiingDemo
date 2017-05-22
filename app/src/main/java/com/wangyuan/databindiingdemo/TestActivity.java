package com.wangyuan.databindiingdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by wangyuan on 2017/5/11.
 */

public class TestActivity extends AppCompatActivity {

    private ImageView mIvImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mIvImage = (ImageView) findViewById(R.id.iv_image1);
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494489704090&di=3911fc42ca02cb97b84c670b88f7eae7&imgtype=0&src=http%3A%2F%2Fimg.duoziwang.com%2F2017%2F04%2F15%2FB1282.jpg";
        Glide.with(this).load(url).placeholder(R.drawable.ic_launcher).into(mIvImage);
    }
}
