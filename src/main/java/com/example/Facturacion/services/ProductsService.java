package com.example.Facturacion.services;


import com.example.Facturacion.entities.ClientsModel;
import com.example.Facturacion.entities.ProductsModel;
import com.example.Facturacion.exception.AlreadyExistsException;
import com.example.Facturacion.exception.IdNotValidException;
import com.example.Facturacion.exception.NotFoundException;
import com.example.Facturacion.repository.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;

	//Método para crear nuevos productos, controla que el producto no existe a partir del código que es único.
	public ProductsModel create(ProductsModel newProduct) throws AlreadyExistsException {
		Optional<ProductsModel> productOp = this.productsRepository.findByCode(newProduct.getCode());

		if (productOp.isPresent()){
			log.info("El producto que intenta agregar ya existe en la base de datos: " + newProduct);
			throw new AlreadyExistsException("El producto que intenta agregar ya existe en la base de datos.");
		}else {
			return this.productsRepository.save(newProduct);
		}
	}

	//Método para actualizar productos, controla que el ID brindado es válido (positivo) y si existe en la base de datos, antes de intentar actualizar.
	public ProductsModel update(ProductsModel newProduct, Long id) throws Exception {
		log.info("ID INGRESADO: " + id);
		if (id <= 0){
			throw new IdNotValidException("El id brindado no es valido.");
		}

		Optional<ProductsModel> productOp = this.productsRepository.findById(id);

		if (productOp.isEmpty()){
			log.info("El producto que intenta modificar no existe en la base de datos: " + newProduct);
			throw new NotFoundException("El producto que intenta modificar no existe en la base de datos.");
		}else {
			log.info("El producto fue encontrado.");
			ProductsModel productBd = productOp.get();

			productBd.setCode(newProduct.getCode());
			productBd.setDescription(newProduct.getDescription());
			productBd.setStock(newProduct.getStock());
			productBd.setPrice(newProduct.getPrice());

			log.info("Producto actualizado : " + productBd);

			return this.productsRepository.save(productBd);
		}
	}

	// Método para buscar un cliente en particular, con el ID.
	public ProductsModel findById(Long id) throws Exception {
		if (id <= 0){
			throw new IdNotValidException("El id brindado no es valido.");
		}

		Optional<ProductsModel> productOp = this.productsRepository.findById(id);

		if (productOp.isEmpty()){
			log.info("El producto con el id brindado no existe en la base de datos: " + id);
			throw new NotFoundException("El producto que intenta solicitar no existe.");
		}else {
			return productOp.get();
		}
	}
	//Método para buscar todos los clientes.
	public List<ProductsModel> findAll(){
		return this.productsRepository.findAll();
	}

	public ProductsModel delete(Long id) throws Exception {
		if (id <= 0){
			throw new IdNotValidException("El id brindado no es valido.");
		}

		Optional<ProductsModel> producstOp = this.productsRepository.findById(id);

		if (producstOp.isEmpty()){
			log.info("El producto con el id brindado no existe en la base de datos: " + id);
			throw new NotFoundException("El producto que intenta solicitar no existe.");
		}else {
			log.info("El Id Ingresado: " + id + " ha sido eliminado.");
			producstOp.get().setStatus(false);
			productsRepository.save(producstOp.get());
			return producstOp.get();
		}
	}

}
