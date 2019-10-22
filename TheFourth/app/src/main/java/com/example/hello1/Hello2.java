package com.example.hello1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Hello2 extends AppCompatActivity implements View.OnClickListener {

    public static  final String TAG="Hello2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Hello2");
        setContentView(R.layout.activity_hello2);
        settupClicks();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        if(v.getId()==R.id.btToHello1){
            intent=new Intent(Hello2.this,Hello1.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.btToHello2){
            intent=new Intent(Hello2.this,Hello2.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.btToHello3){
            intent=new Intent(Hello2.this,Hello3.class);
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
