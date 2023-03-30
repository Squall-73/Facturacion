package com.example.Facturacion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
@Table(name = "Products")
public class ProductsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
	@Column(unique = true)
    private String code;
	@Min(0)
    private int stock;
	@Min(0)
    private double price;
}
