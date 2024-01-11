package com.lld.two.e_factory_pattern.usecase;

import com.lld.two.e_factory_pattern.usecase.parser.*;
import com.lld.two.e_factory_pattern.usecase.printer.*;
import com.lld.two.e_factory_pattern.usecase.processor.*;

public class SpreadsheetDocumentFactory implements DocumentFactory{
    public DocumentType supportsType(){
        return DocumentType.SPREAD_SHEET;
    }
    public DocumentParser createDocumentParser(String path){
        return new SpreadsheetDocumentParser(path);
    }
    public DocumentPrinter createDocumentPrinter(DocumentProcessor processor){
        return new SpreadsheetDocumentPrinter(processor);
    }
    public DocumentProcessor createDocumentProcessor(String documentName){
        return new SpreadsheetDocumentProcessor(documentName);
    }
}