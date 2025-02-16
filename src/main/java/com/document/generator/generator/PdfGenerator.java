package com.document.generator.generator;

import com.document.generator.model.Transaction;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Component
public class PdfGenerator implements FileGenerator<byte[]> {

    @Override
    public byte[] generateFile(List<Transaction> transactions) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 16);
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Transaction Report");
            contentStream.newLineAtOffset(0, -30);
            contentStream.showText("ID: 1 | Amount: 100.50 | Description: Sample Transaction");
            contentStream.endText();
            contentStream.close();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            document.save(outputStream);
            document.close();

            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    }
}