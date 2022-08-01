package com.example.vlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Method;

public class CompSci extends AppCompatActivity {
    ImageView ib;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comp_sci);
        ImageView ib= findViewById(R.id.bk);



        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method("letusc_organized.pdf");
            }
        });


    }

    public void method(String src)
    {
        Intent i = new Intent(CompSci.this,PDFViewer.class);
        i.putExtra("source", src);
        startActivity(i);


    }

}