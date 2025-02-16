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
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/export")
public class CsvExportController {

    @GetMapping("/csv")
    public ResponseEntity<byte[]> exportCsv() {
        String csvData = "ID,Name,Amount\n1,John Doe,100.50\n2,Jane Doe,250.75\n";
        byte[] csvBytes = csvData.getBytes(StandardCharsets.UTF_8);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=transactions.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(csvBytes);
    }
}
