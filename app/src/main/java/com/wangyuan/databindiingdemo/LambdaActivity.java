package com.wangyuan.databindiingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wangyuan.databindiingdemo.bean.MessageBean;
import com.wangyuan.databindiingdemo.databinding.ActivityLanbdaBinding;

/**
 * Created by wangyuan on 2017/5/11.
 */

public class LambdaActivity extends AppCompatActivity {
    ActivityLanbdaBinding mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_lanbda);
        MessageBean msg = new MessageBean();
        msg.firtName = "11111111111";
        msg.secondName = "222222222";
        mBinding.setMessageBean(msg);
        mBinding.setPreSenter(new PreSenter());
    }

    public class PreSenter {
        public void onClick(MessageBean msg) {
            Toast.makeText(getApplicationContext(), msg.secondName, Toast.LENGTH_SHORT).show();
        }
        public void onClick(View v, MessageBean msg) {
            Toast.makeText(getApplicationContext(), "带view参数" + msg.secondName, Toast.LENGTH_SHORT).show();
        }
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "11111111123231", Toast.LENGTH_SHORT).show();
        }

        /**
         * 还未测试
         * @param msg
         */
        public void onFocusChange(MessageBean msg) {
            Toast.makeText(getApplicationContext(), "onFocusChage" + msg.secondName, Toast.LENGTH_SHORT).show();
        }
    }
}
