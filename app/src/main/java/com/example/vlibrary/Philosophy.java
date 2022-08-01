package com.example.vlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Philosophy extends AppCompatActivity {
    ImageView ib3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.philosophy);
        ib3= findViewById(R.id.bk3);



        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method("Sad-darshana.pdf");
            }
        });
    }


    public void method(String src)
    {
        Intent i = new Intent(Philosophy.this,PDFViewer.class);
        i.putExtra("source", src);
        startActivity(i);


    }
}