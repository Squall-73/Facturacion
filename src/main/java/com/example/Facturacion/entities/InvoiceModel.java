package com.example.Facturacion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class InvoiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date created_at;
	@Min(0)
    private double total;
    @ManyToOne
    @JoinColumn(name="client_id")
     private ClientsModel clientsModel;

}
