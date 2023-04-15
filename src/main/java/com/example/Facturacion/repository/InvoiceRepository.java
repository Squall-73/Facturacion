package com.example.Facturacion.repository;

import com.example.Facturacion.entities.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceModel,Long> {

}
