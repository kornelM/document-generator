package com.document.generator.generator;

import com.document.generator.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HtmlGenerator implements FileGenerator<byte[]> {

    @Override
    public byte[] generateFile(List<Transaction> transactions) {
        String htmlContent = "<html><head><title>Transactions</title></head><body>" +
                "<h1>Transaction Report</h1>" +
                "<table border='1'><tr><th>ID</th><th>Amount</th><th>Description</th></tr>" +
                "<tr><td>1</td><td>100.50</td><td>Sample Transaction</td></tr>" +
                "</table></body></html>";

        return htmlContent.getBytes();
    }
}
