package com.document.generator.controllers;

import com.document.generator.service.TransactionService;
import com.itextpdf.xmp.impl.Base64;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DocumentController {

    private final TransactionService transactionService;


//    @GetMapping("/api/export")
//    public ResponseEntity<?> exportTransactions(@RequestParam String format) {
//        byte[] file = transactionService.exportTransactions(format);
//
//        String contentType;
//        String fileName;
//
//        switch (format.toLowerCase()) {
//            case "pdf":
//                contentType = "application/pdf";
//                fileName = "transactions.pdf";
//                break;
//            case "xlsx":
//                contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//                fileName = "transactions.xlsx";
//                break;
//            case "csv":
//                contentType = "text/csv";
//                fileName = "transactions.csv";
//                break;
//            default:
//                return ResponseEntity.badRequest().body("Unsupported format: " + format);
//        }
//        CustomResponse customResponse = CustomResponse.builder()
//                .name(fileName)
//                .file(file)
//                .build();
//        return ResponseEntity.ok()
//                .header("Content-Disposition", "attachment; filename=" + fileName)
//                .contentType(MediaType.TEXT_PLAIN)
//                .body(customResponse);
//    }

//    @GetMapping("/export2")
//    public ResponseEntity<?> exportTransactions2(@RequestParam String format) {
//        byte[] file = transactionService.exportTransactions(format);
//
//        String contentType;
//        String fileName;
//
//        switch (format.toLowerCase()) {
//            case "pdf":
//                contentType = "application/pdf";
//                fileName = "transactions.pdf";
//                break;
//            case "xlsx":
//                contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//                fileName = "transactions.xlsx";
//                break;
//            case "csv":
//                contentType = "text/csv";
//                fileName = "transactions.csv";
//                break;
//            default:
//                return ResponseEntity.badRequest().body("Unsupported format: " + format);
//        }
//
//        return ResponseEntity.ok()
//                .header("Content-Disposition", "attachment; filename=" + fileName)
//                .contentType(org.springframework.http.MediaType.parseMediaType(contentType))
//                .body(file);
//    }

}