package com.example.vlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Others extends AppCompatActivity {
    ImageView ib4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.others);
        ib4= findViewById(R.id.bk4);


        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method("Think-And-Grow-Rich_organized.pdf");
            }
        });

    }

    public void method(String src)
    {
        Intent i = new Intent(Others.this,PDFViewer.class);
        i.putExtra("source", src);
        startActivity(i);

    }

}