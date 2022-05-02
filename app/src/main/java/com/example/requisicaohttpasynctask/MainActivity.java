package com.example.requisicaohttpasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements TarefaInterface{
    private ImageView image;
    private Button button;
    private ProgressDialog progress;
    private Tarefa tarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=findViewById(R.id.image1);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress=ProgressDialog.show(MainActivity.this, "Download", "Downloading");
                tarefa=new Tarefa(MainActivity.this, progress, MainActivity.this);
                tarefa.execute("https://pngimg.com/uploads/simpsons/simpsons_PNG88.png");
            }
        });
    }

    @Override
    public void depoisDownload(Bitmap bitmap){
        image.setImageBitmap(bitmap);
    }
}