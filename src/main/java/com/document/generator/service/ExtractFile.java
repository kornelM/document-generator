package com.document.generator.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExtractFile<T> {

    private final T response;
}
