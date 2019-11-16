package com.example.recylerview;

import android.content.Context;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mfruitlist;

    //定义一个内部类ViewHolder， 通过view找到fruitImage和fruitName
    static class ViewHolder extends RecyclerView.ViewHolder{
        //用于保存最外层布局实例
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        //设置系数
        TextView fruitNo;

        //增删改的按钮
        Button Add;
        Button Delete;
        Button Update;
        //可编辑文本
        EditText edName;


        public ViewHolder(View view){
            super(view);
            fruitView=view;
            fruitImage=(ImageView) view.findViewById(R.id.fruit_image);
            fruitName=(TextView) view.findViewById(R.id.fruit_name);
            fruitNo=(TextView)view.findViewById(R.id.fruit_No);

            Add=(Button) view.findViewById(R.id.bt_Add);
            Delete=(Button) view.findViewById(R.id.bt_Delete);
            Update=(Button) view.findViewById(R.id.bt_Update);

            edName=(EditText) view.findViewById(R.id.edit_name);

        }
    }

    public FruitAdapter(List<Fruit> fuitList){
        mfruitlist =fuitList;
    }

    /**
     * 用于创建ViewHolder实例的
     * 把fruit_item的布局加载到ViewHolder上
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        //为视图添加点击事件
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int position = holder.getAdapterPosition();
                final Fruit fruit = mfruitlist.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(),
                        Toast.LENGTH_SHORT).show();

                //点击时显示按钮
                holder.Add.setVisibility(View.VISIBLE);
                holder.Delete.setVisibility(View.VISIBLE);
                holder.Update.setVisibility(View.VISIBLE);
                holder.fruitName.setVisibility(View.GONE);
            }
        });

        /**
         * 删除功能
         */
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete(holder);
                hideAll(holder);
            }
        });

        /**
         * 添加功能
         */
        holder.Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add(holder);
                hideAll(holder);
            }
        });

        //更新功能
        holder.Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                show(holder);

                //设置编辑内容(添加文本编辑监听事件)
                holder.edName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    int position=holder.getAdapterPosition();
                    Fruit f= mfruitlist.get(position);  //获取当前实例
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                        if(actionId == EditorInfo.IME_ACTION_DONE){//按下完成按钮
                            String name=holder.edName.getText().toString(); //获取文本内容
                            f.setName(getRandomLengthName(name)); //设置当前实例的文本
                            showOrHide(v.getContext()); //隐藏虚拟键盘
                            notifyItemChanged(position); //实现单个更新的刷新
                            hide(holder);
                            return false;
                        }
                        return false;
                    }
                });

            }

        });

        //设置图片的点击事件
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Fruit fruit= mfruitlist.get(position);
                Toast.makeText(v.getContext(),"you clicked image "+fruit.getName(),
                        Toast.LENGTH_SHORT).show();

                holder.Add.setVisibility(View.GONE);
                holder.Delete.setVisibility(View.GONE);
                holder.Update.setVisibility(View.GONE);
                holder.fruitName.setVisibility(View.VISIBLE);
                holder.edName.setVisibility(View.GONE);

            }
        });
        return holder;
    }

    /**
     * 用于对RecyclerView子项的数据进行赋值
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.ViewHolder holder, int position) {
        Fruit fruit= mfruitlist.get(position); //获得当前项的实例
        //对子项数据进行赋值
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
        holder.fruitNo.setText(String.valueOf(position+1));

    }

    //用于知道RecyclerView一共有多少子项
    @Override
    public int getItemCount() {
        return mfruitlist.size();
    }

    /**
     * 实现删除功能
     * @param holder
     */
    public void Delete(ViewHolder holder){
        int position=holder.getAdapterPosition();

        notifyItemRemoved(position); //删除某条数据时单一数据刷新
        notifyItemRangeChanged(position,getItemCount()); //防止删除错乱 IndexOutOfIndexException等问题
        mfruitlist.remove(position); //从列表中移除该数据

    }

    /**
     * 实现添加功能
     * @param holder
     */
    public void Add(ViewHolder holder){

        int position=holder.getAdapterPosition();
        Fruit fruit1= mfruitlist.get(position);
        String fruitName=fruit1.getName();
        int fruitId=fruit1.getImageId();

        Fruit fruit=new Fruit(fruitName,fruitId);
        mfruitlist.add(fruit);

        notifyItemRangeChanged(position,getItemCount());
    }

    //如果输入法在窗口上已经显示，则隐藏，反之则显示
    public static void showOrHide(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    //隐藏对话框
    public void hide(ViewHolder holder){
        holder.edName.setVisibility(View.GONE);
        holder.fruitName.setVisibility(View.VISIBLE);
    }

    //显示编辑的对话框
    public void show(ViewHolder holder){
         holder.Add.setVisibility(View.GONE);
         holder.Delete.setVisibility(View.GONE);
         holder.Update.setVisibility(View.GONE);
         holder.edName.setVisibility(View.VISIBLE);

    }

    //隐藏所有的按钮
    public void hideAll(ViewHolder holder){
        holder.Add.setVisibility(View.GONE);
        holder.Delete.setVisibility(View.GONE);
        holder.Update.setVisibility(View.GONE);
        holder.edName.setVisibility(View.GONE);
    }

    //构造出随机长度的信息
    private String getRandomLengthName(String name) {
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
}
