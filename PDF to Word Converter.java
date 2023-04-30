import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PDFToWordConverter {
    public static void main(String[] args) {
        try {
            // Load the PDF file
            PDDocument pdfDoc = PDDocument.load(new FileInputStream("input.pdf"));

            // Extract text from PDF file
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(pdfDoc);

            // Create a new Word document
            XWPFDocument doc = new XWPFDocument();

            // Add the extracted text to the Word document
            XWPFParagraph para = doc.createParagraph();
            XWPFRun run = para.createRun();
            run.setText(text);

            // Save the Word document
            FileOutputStream out = new FileOutputStream("output.docx");
            doc.write(out);
            out.close();

            // Close the PDF file
            pdfDoc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
