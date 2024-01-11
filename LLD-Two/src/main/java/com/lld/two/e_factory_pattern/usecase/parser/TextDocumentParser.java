package com.lld.two.e_factory_pattern.usecase.parser;

import com.lld.two.e_factory_pattern.usecase.DocumentType;

public class TextDocumentParser extends DocumentParser{
    public TextDocumentParser(String path) {
        super(path);
    }

    public void parseDocument() {
        // Parse text document
    }

    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }
}
