# Android_Document_Generation_Basic
This App generates pdf  using iTextG


## Code Overview
```
      button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generatePDF();
            }
        });
        
        
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
```
