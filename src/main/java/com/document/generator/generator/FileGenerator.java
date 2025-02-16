package com.document.generator.generator;

import com.document.generator.model.Transaction;

import java.util.List;

public interface FileGenerator<T> {

    T generateFile(List<Transaction> transactions);
}
