package com.test.mylibrary.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 通用viewholder
 */

public class ViewHolder {

    //SparseArray是针对key为Integer,value为object的一个map实现
    //它比hashmap的效率更高，所以以后针对key为Integer的map集合建议使用SparseArray
    private SparseArray<View> mViews;

    private View mConvertView;

    private int position;

    public ViewHolder(Context context,int position,View convertView,ViewGroup parent,int layoutId){

        this.position = position;
        this.mConvertView = convertView;
        mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId,null);
        mConvertView.setTag(this);
    }

    public static ViewHolder getViewHolder(Context context,int position, View convertView, ViewGroup parent, int layoutId){

        if(convertView == null){
            return new ViewHolder(context,position, convertView,parent,layoutId);
        }else{
            return (ViewHolder) convertView.getTag();
        }
    }

    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if(view == null){
            view = mConvertView.findViewById(viewId);
        }
        return (T)view;
    }

    public View getmConvertView(){
        return mConvertView;
    }

    /**
     * 获取TextView控件并设置值
     * @param viewId 控件ID
     * @param text 文本
     * @return viewholder
     */
    public ViewHolder setTextView(int viewId, String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }
    /**
     * 获取ImageView控件并设置值
     * @param viewId 控件ID
     * @param resId 资源ID
     * @return viewholder
     */
    public ViewHolder setImageView(int viewId, int resId){
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }
    /**
     * 获取ImageView控件并设置值
     * @param viewId 控件ID
     * @param bitmap bitmap
     * @return viewholder
     */
    public ViewHolder setImageView(int viewId, Bitmap bitmap){
        ImageView imageView = getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }
    /**
     * 获取ImageView控件并设置值
     * @param viewId 控件ID
     * @param drawable drawable
     * @return viewholder
     */
    public ViewHolder setImageView(int viewId, Drawable drawable){
        ImageView imageView = getView(viewId);
        imageView.setImageDrawable(drawable);
        return this;
    }
    /**
     * 获取ImageView控件并设置值
     * @param viewId 控件ID
     * @param url 图片地址
     * @return viewholder
     */
    public ViewHolder setImageView(int viewId, String url){
        ImageView imageView = getView(viewId);
        //自己实现图片下载
        return this;
    }
}
