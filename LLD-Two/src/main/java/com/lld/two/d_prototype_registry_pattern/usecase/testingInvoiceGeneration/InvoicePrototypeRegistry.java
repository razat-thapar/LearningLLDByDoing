package com.lld.two.d_prototype_registry_pattern.usecase.testingInvoiceGeneration;

public interface InvoicePrototypeRegistry {

    void addPrototype(Invoice user);

    Invoice getPrototype(InvoiceType type);

    Invoice clone(InvoiceType type);
}
