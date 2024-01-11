package com.lld.two.e_factory_pattern.usecase.processor;

import com.lld.two.e_factory_pattern.usecase.DocumentType;

public abstract class DocumentProcessor {
    private String documentName;

    public DocumentProcessor(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentName() {
        return documentName;
    }

    public abstract void processDocument();

    public abstract DocumentType supportsType();
}
