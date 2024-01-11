package com.lld.two.e_factory_pattern.usecase.parser;

import com.lld.two.e_factory_pattern.usecase.DocumentType;

public abstract class DocumentParser {
    private final String path;

    public DocumentParser(String path) {
        this.path = path;
    }

    public abstract void parseDocument();

    public String getPath() {
        return path;
    }

    public abstract DocumentType supportsType();
}
