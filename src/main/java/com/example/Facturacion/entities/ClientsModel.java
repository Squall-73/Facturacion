package com.example.Facturacion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
@Table(name = "clients")
public class ClientsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastname;
    @NotNull
	@Column(unique = true, name="docnumber")
	private String docNumber;



}
