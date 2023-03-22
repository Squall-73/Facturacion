package com.example.Facturacion.entities;

import jakarta.persistence.*;

@Entity
public class Invoice_details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoice_details_id;
    private int amount;
    private double price;
    @ManyToOne
    @JoinColumn(name="invoice_id")
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Products product;

    public Invoice_details() {
    }

    public int getInvoice_details_id() {
        return invoice_details_id;
    }

    public void setInvoice_details_id(int invoice_details_id) {
        this.invoice_details_id = invoice_details_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
