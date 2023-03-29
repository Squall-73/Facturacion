package com.example.Facturacion.controller;

import com.example.Facturacion.entities.ProductsModel;
import com.example.Facturacion.exception.AlreadyExistsException;
import com.example.Facturacion.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/products")
public class ProductsController {

	@Autowired
	private ProductsService productsService;

	@PostMapping(path = "/")
	public ResponseEntity<ProductsModel> create(@RequestBody ProductsModel product) throws AlreadyExistsException {
		return new ResponseEntity<>(this.productsService.create(product), HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<ProductsModel> update(@RequestBody ProductsModel product, @PathVariable Long id) throws Exception {
		return new ResponseEntity<>(this.productsService.update(product,id), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<ProductsModel> findById(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(this.productsService.findById(id), HttpStatus.OK);
	}

	@GetMapping(path = "/")
	public ResponseEntity<List<ProductsModel>> findAll(){
		return new ResponseEntity<>(this.productsService.findAll(), HttpStatus.OK);
	}

}
