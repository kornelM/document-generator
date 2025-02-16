package com.document.generator.controllers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/export")
public class PdfExportController {

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> exportPdf() throws IOException {
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

        byte[] fileBytes = outputStream.toByteArray();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=transactions.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(fileBytes);
    }
}
