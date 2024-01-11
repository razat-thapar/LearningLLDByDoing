package com.lld.two.e_factory_pattern.usecase.printer;


import com.lld.two.e_factory_pattern.usecase.DocumentType;
import com.lld.two.e_factory_pattern.usecase.processor.DocumentProcessor;

public class TextDocumentPrinter extends DocumentPrinter {

    public TextDocumentPrinter(DocumentProcessor processor) {
        super(processor);
    }

    public void printDocument() {
        // Print text document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }
}
