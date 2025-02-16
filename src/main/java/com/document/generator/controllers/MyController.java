package com.document.generator.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transactions")
public class MyController {

    @GetMapping("/export")
    public ResponseEntity<Map<String, Object>> exportTransactions() {
        List<String[]> transactions = getTransactions();
        Map<String, Object> response = new HashMap<>();

        if (transactions.isEmpty()) {
            response.put("status", "NO_DATA");
            response.put("file", null);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        try {
            String csvContent = generateCsv(transactions);
            String encodedCsv = Base64.getEncoder().encodeToString(csvContent.getBytes(StandardCharsets.UTF_8));
            response.put("status", "SUCCESS");
            response.put("file", encodedCsv);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "FAILURE");
            response.put("file", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    private List<String[]> getTransactions() {
        return Arrays.asList(
                new String[]{"ID", "Date", "Amount", "Description"},
                new String[]{"1", "2024-02-14", "100.00", "Deposit"},
                new String[]{"2", "2024-02-13", "-50.00", "Withdrawal"}
        );
    }

    private String generateCsv(List<String[]> data) {
        return data.stream()
                .map(row -> String.join(",", row))
                .collect(Collectors.joining("\n"));
    }
}