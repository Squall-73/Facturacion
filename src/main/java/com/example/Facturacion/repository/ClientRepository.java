package com.example.Facturacion.repository;

import com.example.Facturacion.entities.ClientsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientsModel,Long> {

	Optional<ClientsModel> findByDocNumber(String docNumber);
}
