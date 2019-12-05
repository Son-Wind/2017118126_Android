package com.example.androidthreadtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text;
    public  static final int UPDATE_TEXT=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.text);
        Button changeText=findViewById(R.id.change_text);
        changeText.setOnClickListener(this); //绑定按钮的点击事件
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case UPDATE_TEXT:

                   Show temp=(Show)msg.obj;
                   //进行UI的处理
                   text.setText("我是子线程: "+temp.getId()+"\n"+
                           "我的信号是: "+temp.getCounter());
                      break;
                 default:
                      break;
            }

        }
    };

    @Override
    public void onClick(View v) {
        nThread thread=new nThread();
        thread.start();
    }

    public class nThread extends Thread{

        @Override
        public void run() {
            //每个线程独有的一份变量
            int counter=0;
            while(true){
                counter++;
                Message message=new Message();
                message.what=UPDATE_TEXT;
                //把消息封装为对象传出进行处理
                message.obj=new Show(Thread.currentThread().getId(),counter);
                handler.sendMessage(message);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }



        }
    }
}
//进行信息类的封装
class Show{
    private long id;
    private int counter;

    public Show(long id, int counter) {
        this.id = id;
        this.counter = counter;
    }

    public long getId() {
        return id;
    }

    public int getCounter() {
        return counter;
    }
}
