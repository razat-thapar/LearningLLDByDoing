package com.lld.two.e_factory_pattern.usecase;

import com.lld.two.e_factory_pattern.usecase.parser.DocumentParser;
import com.lld.two.e_factory_pattern.usecase.printer.DocumentPrinter;
import com.lld.two.e_factory_pattern.usecase.processor.DocumentProcessor;

public interface DocumentFactory {
    public abstract DocumentType supportsType();
    public abstract DocumentParser createDocumentParser(String path);
    public abstract DocumentPrinter createDocumentPrinter(DocumentProcessor processor);
    public abstract DocumentProcessor createDocumentProcessor(String documentName);
}
