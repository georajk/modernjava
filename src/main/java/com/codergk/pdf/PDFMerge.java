package com.codergk.pdf;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import java.io.File;
import java.io.IOException;

public class PDFMerge {
    public static void main(String[] args) throws IOException {

        PDFMergerUtility PDFmerger = new PDFMergerUtility();

        //Setting the destination file
        PDFmerger.setDestinationFileName("C:\\Personal\\Visa\\2021Renewal\\UtilityCouncilTilldate.pdf");

        PDFmerger.addSource(new File("C:\\Personal\\Visa\\2021Renewal\\Council2021.pdf"));
        PDFmerger.addSource(new File("C:\\Personal\\Visa\\2021Renewal\\Council2020.pdf"));

        PDFmerger.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
        System.out.println("Documents merged");
    }
}