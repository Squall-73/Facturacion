package com.example.Facturacion.repository;

import com.example.Facturacion.entities.InvoiceDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetailsModel,Long> {
}
