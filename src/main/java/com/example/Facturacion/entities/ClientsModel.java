package com.example.Facturacion.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


import java.util.List;


@Entity
@Data
@Table(name = "clients")
public class ClientsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@NotNull
	@Length(min=3)
    private String name;
	@NotNull
	@Length(min=3)
    private String lastname;
    @NotNull
	@Length(min=6)
	@Column(unique = true, name="docnumber")
	private String docNumber;
	@NotNull
	private boolean status =true;
	@JsonManagedReference("clientsModel")
	@OneToMany(mappedBy = "clients")
	private List<InvoiceModel> invoice;


}
