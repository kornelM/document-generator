package com.document.generator.generator;

import com.document.generator.model.Transaction;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.util.List;

@Component
public class CsvGenerator implements FileGenerator<String> {

    @Override
    public String generateFile(List<Transaction> transactions) {
        try (StringWriter sw = new StringWriter(); CSVWriter writer = new CSVWriter(sw)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ID,Description,Amount,Date");

            for (Transaction transaction : transactions) {
                stringBuilder.append(
                        String.join(
                                ",",
                                transaction.getId(),
                                transaction.getDescription(),
                                transaction.getAmount().toString(),
                                transaction.getDate().toString(),
                                "\n"
                        )
                );
            }

            return stringBuilder.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error generating CSV", e);
        }
    }
}
