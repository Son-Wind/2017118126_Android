package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        progressDialog=new ProgressDialog(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt=findViewById(R.id.download);

        bt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        DownloadTask task1=new DownloadTask();
        task1.execute();
//        task1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//        DownloadTask task2=new DownloadTask();
//        task2.execute();
//        task2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }


    /**
     * 异步下载任务
     */
    class DownloadTask extends AsyncTask<Void,Integer,Boolean>{

        Random r=new Random();
        int i=r.nextInt()%100+1;
        String s=null;

        @Override
        protected void onPreExecute() {
            s="The film "+i;
            progressDialog.setTitle(s);
            progressDialog.setCancelable(true);
            progressDialog.show();

        }

        @Override
        protected Boolean doInBackground(Void... parms) {
            int downloadPercent=0;
            while (true){
                downloadPercent+=1;
                publishProgress(downloadPercent);
                if(downloadPercent>=100){
                    break;
                }
                try{
                    Thread.sleep(100);
                }catch (Exception e){

                }

            }

            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressDialog.setMessage("Download "+values[0]+"%");
        }

        @Override
        protected void onPostExecute(Boolean result) {

            progressDialog.dismiss();
            if(result){
                Toast.makeText(MainActivity.this,s+" Download succeeded",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this,"Download failed",Toast.LENGTH_SHORT).show();
            }
        }
    }


}



