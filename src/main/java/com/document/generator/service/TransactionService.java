package com.document.generator.service;

import com.document.generator.generator.CsvGenerator;
import com.document.generator.generator.PdfGenerator;
import com.document.generator.generator.XlsxGenerator;
import com.document.generator.model.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class TransactionService {

    private final PdfGenerator pdfGenerator;
    private final XlsxGenerator xlsxGenerator;
    private final CsvGenerator csvGenerator;

    public TransactionService(PdfGenerator pdfGenerator, XlsxGenerator xlsxGenerator, CsvGenerator csvGenerator) {
        this.pdfGenerator = pdfGenerator;
        this.xlsxGenerator = xlsxGenerator;
        this.csvGenerator = csvGenerator;
    }

    public ExtractFile exportTransactions(String format) {
        List<Transaction> transactions = getDummyTransactions();

        switch (format.toLowerCase()) {
//            case "pdf":
//                return pdfGenerator.generateFile(transactions);
//            case "xlsx":
//                return xlsxGenerator.generateFile(transactions);
            case "csv":
                return new ExtractFile<>(csvGenerator.generateFile(transactions));
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }

    private List<Transaction> getDummyTransactions() {
        return Arrays.asList(
                new Transaction("1", "Payment A", BigDecimal.valueOf(100.50), LocalDate.now()),
                new Transaction("2", "Payment B", BigDecimal.valueOf(200.00), LocalDate.now().minusDays(1)),
                new Transaction("3", "Payment C", BigDecimal.valueOf(300.75), LocalDate.now().minusDays(2))
        );
    }
}
