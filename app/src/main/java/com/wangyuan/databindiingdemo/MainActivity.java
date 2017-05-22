package com.wangyuan.databindiingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewStubProxy;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewStub;
import android.widget.Toast;

import com.wangyuan.databindiingdemo.bean.MessageBean;
import com.wangyuan.databindiingdemo.databinding.ActivityMainBinding;
import com.wangyuan.databindiingdemo.databinding.ViewstubLayoutBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MessageBean m = new MessageBean();
        m.id = 1;
        m.firtName = "testDataBinding";
        m.secondName = "Hello World! ";
        m.thirdName = "测试include标签";
        binding.setMessageBean(m);
//        binding.setVariable(R.id.basic, m);
//        binding.firstName.setText("测试DataBinding");
        binding.setPreSenter(new PreSenter());
        ViewStubProxy proxy = binding.databindingViewstub;
        proxy.setContainingBinding(binding);
        proxy.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub viewStub, View view) {
                ViewstubLayoutBinding db = DataBindingUtil.bind(view);
                db.ivViewstub.setImageResource(R.mipmap.ic_launcher);
            }
        });
        if(proxy.isInflated()) {
            proxy.getViewStub().inflate();
        }

//        iv.setImageResource(R.mipmap.ic_launcher);
    }

    public class PreSenter implements TextWatcher, View.OnClickListener {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            binding.firstName.setText(charSequence);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.first_name:
                    Toast.makeText(getApplicationContext(), "测试binding点击" , Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        public void getDataFromBindXml(MessageBean b){
            b.secondName = "Hello World! " + b.firtName;
            binding.secondName.setText(b.secondName);
        }
    }
}
