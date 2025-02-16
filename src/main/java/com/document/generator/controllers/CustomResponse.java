package com.document.generator.controllers;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class CustomResponse {

    private final String name;
    private byte[] file;
}
