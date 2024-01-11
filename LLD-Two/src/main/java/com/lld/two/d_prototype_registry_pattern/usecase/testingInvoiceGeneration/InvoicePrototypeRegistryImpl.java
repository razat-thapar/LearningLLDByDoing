package com.lld.two.d_prototype_registry_pattern.usecase.testingInvoiceGeneration;

import java.util.*;

public class InvoicePrototypeRegistryImpl implements InvoicePrototypeRegistry {
    private Map<InvoiceType,Invoice> map = new HashMap<>();
    @Override
    public void addPrototype(Invoice user){
        if(user != null){
            map.put(user.getType(),user);
        }
    }
    @Override
    public Invoice getPrototype(InvoiceType type){
        return map.get(type);
    }
    @Override
    public Invoice clone(InvoiceType type){
        Invoice prototype = map.get(type);
        if(prototype != null){
            return prototype.cloneObject();
        }
        return null;
    }
}
