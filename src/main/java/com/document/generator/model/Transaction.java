package com.document.generator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Transaction {

    private String id;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
}
