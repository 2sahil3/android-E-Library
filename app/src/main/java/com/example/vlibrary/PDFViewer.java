package com.example.vlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;
import java.util.Locale;

public class PDFViewer extends AppCompatActivity {
    TextToSpeech textToSpeech;

    String source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdfviewer);
        Intent i = getIntent();
        source = i.getStringExtra("source");



        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            @Override
            public void onInit(int i)
            {

                // if No error is found then only it will run
                if(i!=TextToSpeech.ERROR){
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.CANADA);
                }
            }
        });

        PDFView pdfView=findViewById(R.id.pdfView);
        pdfView.fromAsset(source)

                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)//do use zoom feature
                .defaultPage(0)//to show selective pages if any


                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)//to add a scroll handle
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                .autoSpacing(false) // add dynamic spacing to fit each page on its own on the screen

                .fitEachPage(true) // fit each page to the view, else smaller pages are scaled relative to largest page.
                .pageSnap(false) // snap pages to screen boundaries
                .pageFling(false) // make a fling change only a single page like ViewPager
                .nightMode(false) //toggle night mode
                .load();
        ImageButton mic = (ImageButton)findViewById(R.id.imageButton);
        mic.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (textToSpeech.isSpeaking()) {
                    textToSpeech.stop();
                }
                else
                {
                    try {
                        extractPDF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }
    public void extractPDF() throws IOException {
        try
        {
            // creating a string for
            // storing our extracted text.
            String extractedText = "";

            // creating a variable for pdf reader
            // and passing our PDF file in it.
            PdfReader reader = new PdfReader("assets/"+source );
            Toast.makeText(getApplicationContext(),""+reader,Toast.LENGTH_SHORT).show();

            // below line is for getting number
            // of pages of PDF file.
            int n = reader.getNumberOfPages();

            // running a for loop to get the data from PDF
            // we are storing that data inside our string.
            for (int i = 0; i < n; i++)

            {
                try {
                    extractedText = PdfTextExtractor.getTextFromPage(reader, i +1).trim() + "\n";
                    textToSpeech.speak(extractedText,TextToSpeech.QUEUE_ADD,null);
                    Log.d("Debug.....!",extractedText);
                }catch (Exception e){
                    extractedText = PdfTextExtractor.getTextFromPage(reader, i).trim() + "\n";
                    textToSpeech.speak(extractedText,TextToSpeech.QUEUE_FLUSH,null);
                    Log.d("Debug.....!",extractedText);
                }
                // to extract the PDF content from the different pages-
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}














/* for (int i = 1; i <= n; i++)

            {
                extractedText = PdfTextExtractor.getTextFromPage(reader, i + 0).trim() + "\n";
                textToSpeech.speak(extractedText,TextToSpeech.QUEUE_FLUSH,null);
                // to extract the PDF content from the different pages-
            }
            Log.d("Debug.....!",extractedText);


            // below line is used for closing reader.
            reader.close();*/