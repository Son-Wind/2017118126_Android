package com.example.recylerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitListt;
    //定义一个内部类ViewHolder， 通过view找到fruitImage和fruitName
    static class ViewHolder extends RecyclerView.ViewHolder{
        //用于保存最外层布局实例
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        //设置系数
        TextView fruitNo;

        public ViewHolder(View view){
            super(view);
            fruitView=view;
            fruitImage=(ImageView) view.findViewById(R.id.fruit_image);
            fruitName=(TextView) view.findViewById(R.id.fruit_name);
            fruitNo=(TextView)view.findViewById(R.id.fruit_No);
        }
    }

    public FruitAdapter(List<Fruit> fuitList){
        mFruitListt=fuitList;
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
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Fruit fruit=mFruitListt.get(position);
                Toast.makeText(v.getContext(),"you clicked view "+fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Fruit fruit=mFruitListt.get(position);
                Toast.makeText(v.getContext(),"you clicked image "+fruit.getName(),
                        Toast.LENGTH_SHORT).show();
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
        Fruit fruit=mFruitListt.get(position); //获得当前项的实例
        //对子项数据进行赋值
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
        holder.fruitNo.setText(String.valueOf(position+1));


    }

    //用于知道RecyclerView一共有多少子项
    @Override
    public int getItemCount() {
        return mFruitListt.size();
    }
}
