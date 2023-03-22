package com.example.Facturacion.repository;

import com.example.Facturacion.entities.Invoice_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Invoice_detailsRepository extends JpaRepository<Invoice_details,Integer> {
}
