package com.lld.two.e_factory_pattern.usecase;

import com.lld.two.e_factory_pattern.usecase.parser.DocumentParser;
import com.lld.two.e_factory_pattern.usecase.printer.DocumentPrinter;
import com.lld.two.e_factory_pattern.usecase.processor.DocumentProcessor;

public class Client {
    private static DocumentFactory documentFactory = new SpreadsheetDocumentFactory();
    public static void main(String[] args) {
        String documentName = "test";
        //parser
        DocumentParser documentParser = documentFactory.createDocumentParser(documentName);
        documentParser.parseDocument();
        //processor.
        DocumentProcessor documentProcessor = documentFactory.createDocumentProcessor(documentName);
        documentProcessor.processDocument();
        //printer.
        DocumentPrinter documentPrinter = documentFactory.createDocumentPrinter(documentProcessor);
        documentPrinter.printDocument();

    }
}
