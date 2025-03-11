package com.document.generator.controllers.fullbody;

import com.document.generator.intefaces.DownloadResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@RequestMapping("/api/export/fullbody")
public class ExcelController {

    @GetMapping("/xls")
    public DownloadResponse exportCsv() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Transactions");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Amount");
        header.createCell(2).setCellValue("Description");

        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue(1);
        dataRow.createCell(1).setCellValue(100.50);
        dataRow.createCell(2).setCellValue("Sample Transaction");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        byte[] fileBytes = outputStream.toByteArray();

        return DownloadResponse.builder()
                .encodedDocument(Base64.getEncoder().encode(fileBytes))
                .documentAsBytes(fileBytes)
                .format("XLS")
                .fileName("my_file_name_xls")
                .build();

    }
}
