package com.example.Facturacion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name = "Products")
public class ProductsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@NotNull
    private String description;
	@NotNull
	@Column(unique = true)
	@Pattern(regexp = "^[A-Za-z]{1,2}[0-9]{4}$")
    private String code;
	@NotNull
	@Min(0)
    private Integer stock;
	@NotNull
	@Min(0)
    private Double price;
	@NotNull
	private boolean status =true;
}
