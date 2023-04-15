package com.example.Facturacion.validator;

import com.example.Facturacion.entities.ProductsModel;
import com.example.Facturacion.exception.MinException;
import com.example.Facturacion.exception.NullException;
import com.example.Facturacion.exception.WrongCodeException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductsValidator {

	public static void productsValidator(ProductsModel newProduct) throws Exception{

		if(!newProduct.getCode().matches("^[A-Za-z]{1,2}[0-9]{4}$")){
			log.info("El código ingresado no respeta la convención elegida");
			throw new WrongCodeException("El código ingresado no respeta la convención elegida");
		}

		if(newProduct.getDescription().isEmpty()){
			log.info("La descripción no puede estar vacía");
			throw new NullException("La descripción no puede estar vacía");
		}
		if(newProduct.getCode().isEmpty()){
			log.info("El código no puede estar vacío");
			throw new NullException("El código no puede estar vacío");
		}
		if(newProduct.getStock()==null){
			log.info("El stock no puede estar vacío");
			throw new NullException("El stock no puede estar vacío");
		}
		if(newProduct.getPrice()==null){
			log.info("El precio no puede estar vacío");
			throw new NullException("El precio no puede estar vacío");
		}
		if(newProduct.getStock()<0){
			log.info("El stock no puede ser un número negativo");
			throw new MinException("El stock no puede ser un número negativo");
		}
		if(newProduct.getPrice()<0){
			log.info("El Precio no puede ser un número negativo");
			throw new MinException("El Precio no puede ser un número negativo");
		}
	}


}
