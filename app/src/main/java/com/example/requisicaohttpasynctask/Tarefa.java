package com.example.requisicaohttpasynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

public class Tarefa extends AsyncTask <String, Void, Bitmap>{

    private Context context;
    private ProgressDialog dialog;


    @Override
    protected Bitmap doInBackground(String... strings) {
        return null;
    }
}
