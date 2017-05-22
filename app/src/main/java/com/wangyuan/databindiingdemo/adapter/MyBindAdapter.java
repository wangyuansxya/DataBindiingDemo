package com.wangyuan.databindiingdemo.adapter;

/**
 * Created by wangyuan on 2017/5/11.
 */

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * databinding自定义属性 指的是自定义xml中某个view的属性
 */
@InverseBindingMethods({@InverseBindingMethod(type = android.widget.TextView.class,
        attribute = "android.text", method="getText", event = "android:textAttrChanged")})
public class MyBindAdapter {

    @BindingAdapter({"app:imageUrl", "app:placeholder"})
    public static void loadImageFromUrl(ImageView mImageView, String imageUrl, Drawable d) {
        Glide.with(mImageView.getContext()).load(imageUrl).placeholder(d).into(mImageView);
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static String getTextString(TextView view) {
        return view.getText().toString();
    }

    /*@BindingAdapter(value ={"android:onTextChange", "android:textAttrChanged"}, requireAll = false)
    public static void setTextWatcher(TextView view, TextViewBindingAdapter.OnTextChanged on, InverseBindingListener textAttrChanged) {

    }*/

    @BindingAdapter("android:text")
    public static void setText(TextView tv, CharSequence newText) {
        CharSequence oldText = tv.getText();
        if(TextUtils.equals(oldText, newText))return;
        tv.setText(newText);
    }
}
