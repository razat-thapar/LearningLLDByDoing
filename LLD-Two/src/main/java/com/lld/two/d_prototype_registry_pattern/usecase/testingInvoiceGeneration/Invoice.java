package com.lld.two.d_prototype_registry_pattern.usecase.testingInvoiceGeneration;


public class Invoice implements ClonableObject<Invoice>{
    private Long invoiceId;
    private String customerName;
    private Double amount;
    private String paymentMethod;
    private InvoiceType type;

    public Invoice(Long invoiceId, String customerName, Double amount, String paymentMethod, InvoiceType type) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.type = type;
    }
    //copy constructor.
    public Invoice(Invoice other) {
        this.invoiceId = other.invoiceId;
        this.customerName = other.customerName;
        this.amount = other.amount;
        this.paymentMethod = other.paymentMethod;
        this.type = other.type;
    }
    @Override
    public Invoice cloneObject(){
        return new Invoice(this);
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public InvoiceType getType() {
        return type;
    }
}