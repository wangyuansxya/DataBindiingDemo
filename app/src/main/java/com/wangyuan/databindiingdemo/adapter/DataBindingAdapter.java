package com.wangyuan.databindiingdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangyuan.databindiingdemo.BR;
import com.wangyuan.databindiingdemo.R;
import com.wangyuan.databindiingdemo.bean.MessageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyuan on 2017/5/10.
 */

public class DataBindingAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private static final int ITEM_VIEW_TYPE_LEFT = 1;
    private static final int ITEM_VIEW_TYPE_TIGHT = 2;

    private LayoutInflater mInflater = null;
    private List<MessageBean> mData = null;

    public DataBindingAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mData = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? ITEM_VIEW_TYPE_LEFT : ITEM_VIEW_TYPE_TIGHT;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = null;
        switch (viewType) {
            case ITEM_VIEW_TYPE_LEFT:
                dataBinding = DataBindingUtil.inflate(mInflater, R.layout.item_left, parent, false);
                break;
            case ITEM_VIEW_TYPE_TIGHT:
                dataBinding = DataBindingUtil.inflate(mInflater, R.layout.item_right, parent, false);
                break;
            default:
                break;
        }
        return new MyViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MessageBean msg = mData.get(position);
        ViewDataBinding dataBinding = holder.getBinding();
        dataBinding.setVariable(BR.msg, msg);
        PreSenter p = new PreSenter();
        dataBinding.setVariable(BR.preSenter, p);
//        holder.itemView.setTag(position);
        /*((ItemLeftBinding) dataBinding).setMsg(msg);
        ((ItemRightBinding) dataBinding).setMsg(msg);
        ((ItemLeftBinding) dataBinding).setPreSenter(p);
        ((ItemRightBinding) dataBinding).setPreSenter(p);*/
        dataBinding.executePendingBindings();//即时数据刷新
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setData(List<MessageBean> l) {
        mData.addAll(l);
    }

    public void add(MessageBean msg) {
        mData.add(msg);
        notifyItemInserted(mData.size());
    }

    public void remove(int position) {
        if(mData.size() > 0){
            mData.remove(position);
            notifyItemRemoved(position);
        }
    }

    public class PreSenter implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.root:
                    if(mOnItemClickListener != null)mOnItemClickListener.onItemClick((int)view.getTag());
                    break;
            }
        }
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
