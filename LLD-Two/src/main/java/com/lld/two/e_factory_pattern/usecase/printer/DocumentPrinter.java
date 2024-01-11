package com.lld.two.e_factory_pattern.usecase.printer;

import com.lld.two.e_factory_pattern.usecase.DocumentType;
import com.lld.two.e_factory_pattern.usecase.processor.DocumentProcessor;

public abstract class DocumentPrinter {

    private final DocumentProcessor processor;

    public DocumentPrinter(DocumentProcessor processor) {
        this.processor = processor;
    }

    public DocumentProcessor getProcessor() {
        return processor;
    }

    public abstract void printDocument();

    public abstract DocumentType supportsType();

}