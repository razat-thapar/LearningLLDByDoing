package com.lld.two.e_factory_pattern.usecase.printer;

import com.lld.two.e_factory_pattern.usecase.DocumentType;
import com.lld.two.e_factory_pattern.usecase.processor.DocumentProcessor;

public class SpreadsheetDocumentPrinter extends DocumentPrinter {

    public SpreadsheetDocumentPrinter(DocumentProcessor processor) {
        super(processor);
    }

    public void printDocument() {
        // Print spreadsheet document
        System.out.println("Printing the spreadsheet document : "+this.getProcessor().getDocumentName());
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }
}
