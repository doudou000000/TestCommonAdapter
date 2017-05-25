package com.test.mylibrary.common;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 *通用Adapter
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    private Context context;

    private List<T> mDatas;

    private int layoutId;

    public CommonAdapter(Context context, List<T> mDatas, int layoutId) {
        this.context = context;
        this.mDatas = mDatas;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = ViewHolder.getViewHolder(context,position,convertView,parent, layoutId);
        setText(getItem(position),holder);
        return holder.getmConvertView();
    }
    public abstract void setText(T t,ViewHolder holder);

    public void setTextView(T t,int viewId){

    }

}
