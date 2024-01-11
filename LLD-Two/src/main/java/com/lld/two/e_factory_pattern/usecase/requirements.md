### Abstract Factory Pattern for Document Processing

## Problem Statement

You are designing a document processing application. Depending on the type of document (e.g., text, spreadsheet, presentation), different processing routines are required. These routines involve multiple steps, such as parsing, formatting, and exporting, which need to be coordinated to ensure correct document processing. You want to create instances of these processing steps without explicitly specifying their classes and ensure that the steps within the same family are compatible.

## Assignment

Your task is to implement the Abstract Factory pattern to create document processors in the document processing application. The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes, allowing for easy addition of new document processor types and ensuring compatibility within families.

### Task 1 - Adding the factory methods to the abstract factory

The abstract factory class has been created for you. You will need to add the factory methods to create document processors, parsers, and printers to the abstract factory class. The method `supportsType` has already been abstracted out for you as an example. You will need to implement the `DocumentFactory` class as a common parent class for all the document factories.

### Task 2 - Implementing the Abstract Factory

Now that you have the abstract factory class, you will need to implement the abstract factory for text and spreadsheet documents. Two classes have been created for you: `TextDocumentFactory` and `SpreadsheetDocumentFactory`. You will need to implement the methods to create compatible document processors, parsers, and printers. Ensure that the created processors, parsers, and printers are compatible within the same family.

### Instructions

1. Implement the `DocumentFactory` interface with methods to create document processors, parsers, and printers.

2. Create concrete implementations of the `DocumentFactory` interface for text and spreadsheet documents. Implement the methods to create compatible document processors, parsers, and printers.

3. Run the provided test cases in the `DocumentFactoryTest` class to verify the correctness of your implementation. The tests will check if all document processors have a common parent class, and if the factory classes can correctly create document processors, parsers, and printers based on the document type and name.