package com.document.generator.generator;

import com.document.generator.model.Transaction;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class XlsxGenerator implements FileGenerator<byte[]> {

    @Override
    public byte[] generateFile(List<Transaction> transactions) {
        try {
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
            workbook.write(outputStream);
            workbook.close();

            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}