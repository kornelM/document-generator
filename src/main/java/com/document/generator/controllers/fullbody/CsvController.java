package com.document.generator.controllers.fullbody;

import com.document.generator.intefaces.DownloadResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@RequestMapping("/api/export/fullbody")
public class CsvController {

    @GetMapping("/csv")
    public DownloadResponse exportCsv() {
        String csvData = "ID,Name,Amount\n1,John Doe,100.50\n2,Jane Doe,250.75\n";
        byte[] csvBytes = csvData.getBytes(StandardCharsets.UTF_8);

        return DownloadResponse.builder()
                .encodedDocument(Base64.getEncoder().encode(csvBytes))
                .documentAsBytes(csvBytes)
                .format("CSV")
                .fileName("my_file_name")
                .build();

    }
}
