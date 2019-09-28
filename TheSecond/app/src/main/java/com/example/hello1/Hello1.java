package com.example.hello1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Hello1 extends AppCompatActivity implements View.OnClickListener {

    public static  final String TAG="Hello1";
    //ObjCount作为类的计数器是,对象公用的计数器
    //mObjCount作为对象的计数器,对象私有的计数器
    private static int ObjCount=0;
    private int mObjCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settupClicks();
        ObjCount++;
        mObjCount=ObjCount;
        setTitle("Hello1");
        Log.d("Hello1"+"-"+mObjCount, "onCreate: ");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG+"-"+mObjCount, "onStart: ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG+"-"+mObjCount, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG+"-"+mObjCount, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG+"-"+mObjCount, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ObjCount--;
        Log.d(TAG+"-"+mObjCount, "onDestroy: ");
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        if(v.getId()==R.id.btToHello1){
            intent=new Intent(Hello1.this,Hello1.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.btToHello2){
            intent=new Intent(Hello1.this,Hello2.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.btToHello3){
            intent=new Intent(Hello1.this,Hello3.class);
            startActivity(intent);
        }
    }
    public void settupClicks(){
        Button b;
        b=(Button) findViewById(R.id.btToHello1);
        b.setOnClickListener(this);
        b=(Button) findViewById(R.id.btToHello2);
        b.setOnClickListener(this);
        b=(Button) findViewById(R.id.btToHello3);
        b.setOnClickListener(this);
    }
}
