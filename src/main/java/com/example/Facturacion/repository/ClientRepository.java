package com.example.Facturacion.repository;

import com.example.Facturacion.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Clients,Integer> {
}
