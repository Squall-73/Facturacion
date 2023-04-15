package com.example.Facturacion.repository;


import com.example.Facturacion.entities.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsModel,Long> {

	Optional<ProductsModel> findByCode(String code);
}
