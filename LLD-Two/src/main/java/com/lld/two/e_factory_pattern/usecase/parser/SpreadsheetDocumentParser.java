package com.lld.two.e_factory_pattern.usecase.parser;

import com.lld.two.e_factory_pattern.usecase.DocumentType;

public class SpreadsheetDocumentParser extends DocumentParser {

    public SpreadsheetDocumentParser(String path) {
        super(path);
    }

    public void parseDocument() {
        // Parse spreadsheet document
        System.out.println("Parsing the spreadsheet document");
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }
}
