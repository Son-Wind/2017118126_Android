package com.example.hello1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Hello1 extends AppCompatActivity implements View.OnClickListener {

    public static  final String TAG="Hello1";
    public int count; //作为一个计数器


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settupClicks();
        setTitle("Hello1");
        //count=count+1;
        //Log.d("Hello1"+"-"+count, "onCreate: ");


    }

    @Override
    protected void onStart() {
        super.onStart();
       // setTitle(TAG+"-"+count);
       // Log.d(TAG+"-"+count ,"onStart: ");
        Log.d(TAG, "onStart: ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        //setTitle(TAG+"-"+count);
        //Log.d(TAG+"-"+count , "onResume: ");
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //setTitle(TAG+"-"+count);
        //Log.d(TAG+"-"+count , "onPause: ");
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
       // setTitle(TAG+"-"+count);
        //Log.d(TAG+"-"+count , "onStop: ");
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //setTitle(TAG+"-"+count);
        //Log.d(TAG+"-"+count , "onDestroy: ");
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        if(v.getId()==R.id.btToHello1){
            intent=new Intent(Hello1.this,Hello1.class);
            startActivity(intent);
            //Log.d(TAG+"-"+count, "onClick: ");
            //setTitle(TAG+"-"+count);
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
