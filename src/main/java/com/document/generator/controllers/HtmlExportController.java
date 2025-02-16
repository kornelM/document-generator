package com.document.generator.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/export")
public class HtmlExportController {

    @GetMapping("/html")
    public ResponseEntity<byte[]> exportHtml() {
        String htmlContent = "<html><head><title>Transactions</title></head><body>" +
                "<h1>Transaction Report</h1>" +
                "<table border='1'><tr><th>ID</th><th>Amount</th><th>Description</th></tr>" +
                "<tr><td>1</td><td>100.50</td><td>Sample Transaction</td></tr>" +
                "</table></body></html>";

        byte[] fileBytes = htmlContent.getBytes();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=transactions.html")
                .contentType(MediaType.TEXT_HTML)
                .body(fileBytes);
    }
}
