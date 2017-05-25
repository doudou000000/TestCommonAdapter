# TestCommonAdapter
为listview和gridview打造通用的Adapter

使用方法：

第一步：添加lib

compile project(path: ':mylibrary')

第二步：编写类实现CommonAdapter<T>

public class MyCommonAdapter extends CommonAdapter<Bean> {

    private Context context;
    private List<Bean> mDatas;

    /**
     * 构造方法
     * @param context 上下文
     * @param mDatas   显示的数据
     * @param layoutId 布局文件ID
     */
    public MyCommonAdapter(Context context, List<Bean> mDatas,int layoutId) {
        super(context, mDatas,layoutId);
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public void setText(final Bean bean, ViewHolder holder) {
        //通过holder设置Textview的值
        holder.setTextView(R.id.id_tilte,bean.getTitle())
                .setTextView(R.id.id_desc,bean.getDesc())
                .setTextView(R.id.id_date,bean.getDate())
                .setTextView(R.id.id_phone,bean.getPhone());
        //获取CheckBox对象
        final CheckBox checkBox = holder.getView(R.id.id_checkBox);
        checkBox.setChecked(bean.isChecked());
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bean.setChecked(checkBox.isChecked());
            }
        });
    }
}

