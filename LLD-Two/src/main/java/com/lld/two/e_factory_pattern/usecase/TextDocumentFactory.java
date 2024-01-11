package com.lld.two.e_factory_pattern.usecase;
import com.lld.two.e_factory_pattern.usecase.parser.*;
import com.lld.two.e_factory_pattern.usecase.printer.*;
import com.lld.two.e_factory_pattern.usecase.processor.*;
public class TextDocumentFactory implements DocumentFactory{
    public DocumentType supportsType(){
        return DocumentType.TEXT;
    }
    public DocumentParser createDocumentParser(String path){
        return new TextDocumentParser(path);
    }
    public DocumentPrinter createDocumentPrinter(DocumentProcessor processor){
        return new TextDocumentPrinter(processor);
    }
    public DocumentProcessor createDocumentProcessor(String documentName){
        return new TextDocumentProcessor(documentName);
    }
}
