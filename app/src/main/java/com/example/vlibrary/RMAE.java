package com.example.vlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RMAE extends AppCompatActivity {
    ImageView ib1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rmae);
        ib1= findViewById(R.id.bk1);



        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method("RMAE-converted.pdf");
            }
        });


    }

    public void method(String src)
    {
        Intent i = new Intent(RMAE.this,PDFViewer.class);
        i.putExtra("source", src);
        startActivity(i);

    }
}