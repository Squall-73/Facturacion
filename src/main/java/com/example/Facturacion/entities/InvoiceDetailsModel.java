package com.example.Facturacion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
@Table(name = "Invoice_Details")
public class InvoiceDetailsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long invoiceDetailsId;
	@Min(0)
    private int amount;
	@Min(0)
    private double price;
    @ManyToOne
    @JoinColumn(name="invoice_id")
    private InvoiceModel invoiceModel;
    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductsModel product;
}
