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

    /**
     * 构造函数
     * @param context  上下文
     * @param mDatas    显示数据
     * @param layoutId  布局ID
     */
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
        //获取viewholder对象
        ViewHolder holder = ViewHolder.getViewHolder(context,position,convertView,parent, layoutId);
        //通过holder和实体类获取控件对象并赋值
        setText(getItem(position),holder);
        //返回convertView
        return holder.getmConvertView();
    }

    /**
     * 通过holder和实体类获取控件对象并赋值
     * @param t        实体类
     * @param holder  viewholder对象
     */
    public abstract void setText(T t,ViewHolder holder);
}
