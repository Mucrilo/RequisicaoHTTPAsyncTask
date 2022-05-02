package com.example.requisicaohttpasynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Tarefa extends AsyncTask <String, Void, Bitmap>{

    private Context context;
    private ProgressDialog dialog;
    private TarefaInterface ti;

    public Tarefa(Context context, ProgressDialog dialog, TarefaInterface ti) {
        this.context = context;
        this.dialog = dialog;
        this.ti = ti;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.show();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap bitmap=null;
        try{
            URL url= new URL(strings[0]);
            HttpURLConnection connection=(HttpURLConnection)
                url.openConnection();
            InputStream input=connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(input);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        dialog.dismiss();
        ti.depoisDownload(bitmap);
    }
}
