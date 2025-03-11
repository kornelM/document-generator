package com.document.generator.intefaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DownloadResponse {

    private byte[] encodedDocument;
    private byte[] documentAsBytes;
    private String format;
    private String fileName;
}
