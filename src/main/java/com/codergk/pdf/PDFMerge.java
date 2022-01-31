package com.codergk.pdf;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PDFMerge {
    public static void main(String[] args) throws IOException {
//        File file1 = new File("C:\\EXAMPLES\\Demo1.pdf");
//        File file2 = new File("C:\\EXAMPLES\\Demo2.pdf");


       // Path path = Path.of("C:\\Personal\\Visa\\utility\\ViewBill (1).pdf" );

       // path.forEach(System.out::println);
        //Instantiating PDFMergerUtility class
        PDFMergerUtility PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("C:\\Personal\\Visa\\2021Renewal\\UtilityCouncilTilldate.pdf");



        PDFmerger.addSource(new File("C:\\Personal\\Visa\\2021Renewal\\Council2021.pdf"));
        PDFmerger.addSource(new File("C:\\Personal\\Visa\\2021Renewal\\Council2020.pdf"));


        PDFmerger.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
        System.out.println("Documents merged");
    }
}