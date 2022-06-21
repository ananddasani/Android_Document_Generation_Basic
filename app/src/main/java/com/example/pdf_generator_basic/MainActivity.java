package com.example.pdf_generator_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generatePDF();
            }
        });
    }

    private void generatePDF() {

        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();

        try {
            File pdfFile = new File(path, "Demo_PDF.pdf");

            if (!pdfFile.exists())
                pdfFile.createNewFile();
            else
                Toast.makeText(this, "PDF already exist, Not creating new one", Toast.LENGTH_SHORT).show();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfFile.getAbsolutePath()));
            document.open();

            //Adding paragraph in the pdf
            Paragraph title_para = new Paragraph();
            String title = "Anand Dasani";
            title_para.add(title);
            title_para.setSpacingAfter(10.0f);
            title_para.setAlignment(Element.ALIGN_CENTER);

            Paragraph des_para = new Paragraph();
            String des = "I am living currently in Porbandar";
            des_para.add(des);

            document.add(title_para);
            document.add(des_para);
            document.close();

            Toast.makeText(this, "PDF Generated Successfully\nLocation :: " + pdfFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
