package com.codergk.pdf;

import java.io.File;
import java.io.IOException;
import com.itextpdf.kernel.geom.AffineTransform;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;


public class PDFBooklet {
    public static final String DEST = "C:\\Personal\\Doc\\BRP_Georaj.pdf";

    public static final String SRC = "C:\\Users\\A710708\\Downloads\\Modern Java in Action, 2nd Edition.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new PDFBooklet().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws IOException {
        PdfDocument srcDoc = new PdfDocument(new PdfReader(SRC));
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));

        float a4Width = PageSize.A4.getWidth();
        float a4Height = PageSize.A4.getHeight();
        PageSize pagesize = new PageSize(a4Width * 2, a4Height * 1);
        pdfDoc.setDefaultPageSize(pagesize);

        int numberOfPages = srcDoc.getNumberOfPages();
        int p = 36;
        PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());
        while ((p - 1) <= numberOfPages) {
            copyPageToDoc(canvas, srcDoc, pdfDoc, p + 3, 0);
            copyPageToDoc(canvas, srcDoc, pdfDoc, p, a4Width );
            canvas.saveState();


            canvas = new PdfCanvas(pdfDoc.addNewPage());
            copyPageToDoc(canvas, srcDoc, pdfDoc, p + 1, 0);
            copyPageToDoc(canvas, srcDoc, pdfDoc, p + 2, a4Width);

            canvas.saveState();



            if ((p - 1) / 4 < numberOfPages / 4) {
                canvas = new PdfCanvas(pdfDoc.addNewPage());
            }

            p += 4;
        }

        pdfDoc.close();
        srcDoc.close();
    }

    private static void copyPageToDoc(PdfCanvas canvas, PdfDocument srcDoc, PdfDocument pdfDoc,
                                      int pageNumber, float offsetX) throws IOException {
        if (pageNumber > srcDoc.getNumberOfPages()) {
            return;
        }

        PdfFormXObject page = srcDoc.getPage(pageNumber).copyAsFormXObject(pdfDoc);
        canvas.addXObject(page, offsetX, 150);
    }
}
