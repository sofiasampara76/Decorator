package ua.edu.ucu.apps;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class SmartDocument implements Document {
    private final String filePath;

    public SmartDocument(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String parse(String filePath) {
        Tesseract tesseract = new Tesseract();
        // Set the path to tessdata
        tesseract.setDatapath("/usr/share/tesseract-ocr/4.00/tessdata");
        tesseract.setLanguage("eng");
        try {
            return tesseract.doOCR(new File(this.filePath));
        } catch (TesseractException e) {
            System.out.println("Error during OCR: " + e.getMessage());
            return "";
        }
    }
}
