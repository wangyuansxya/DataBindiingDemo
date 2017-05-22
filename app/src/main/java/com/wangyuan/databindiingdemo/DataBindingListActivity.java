package com.wangyuan.databindiingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.wangyuan.databindiingdemo.adapter.DataBindingAdapter;
import com.wangyuan.databindiingdemo.bean.MessageBean;
import com.wangyuan.databindiingdemo.databinding.ActivityDataBindingListBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyuan on 2017/5/10.
 * 列表绑定
 */

public class DataBindingListActivity extends AppCompatActivity implements DataBindingAdapter.OnItemClickListener {

    private ActivityDataBindingListBinding mDataBinding = null;
    private DataBindingAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_list);
        mDataBinding.setPreSenter(new PreSenter());
        initData();
        MessageBean msg = new MessageBean();
        mDataBinding.setMsg(msg);
        mDataBinding.listview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new DataBindingAdapter(this);
        mAdapter.setOnItemClickListener(this);
        mAdapter.setData(mData);
        mDataBinding.listview.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getApplicationContext(), "position="+position, Toast.LENGTH_SHORT).show();
    }

    public class PreSenter implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_add:
                    MessageBean bean = new MessageBean();
                    bean.firtName = "9";
                    bean.secondName = "10";
                    mAdapter.add(bean);
                    break;
                case R.id.btn_remove:
                    mAdapter.remove(0);
                    break;
                default:
                    break;
            }
        }
    }
    private List<MessageBean> mData = new ArrayList<>();
    private void initData() {
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494489704090&di=3911fc42ca02cb97b84c670b88f7eae7&imgtype=0&src=http%3A%2F%2Fimg.duoziwang.com%2F2017%2F04%2F15%2FB1282.jpg";
        MessageBean bean = new MessageBean();
        bean.firtName = "1";
        bean.secondName = "2";
        mData.add(bean);
        bean = new MessageBean();
        bean.firtName = "3";
        bean.secondName = "4";
        mData.add(bean);
        bean = new MessageBean();
        bean.firtName = "5";
        bean.secondName = "6";
        mData.add(bean);
        bean = new MessageBean();
        bean.firtName = "7";
        bean.secondName = "8";
        bean.imageUrl = url;
        mData.add(bean);

    }

}
