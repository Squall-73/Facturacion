package com.example.Facturacion.validator;

import com.example.Facturacion.entities.ClientsModel;
import com.example.Facturacion.exception.NullException;
import com.example.Facturacion.exception.TooShortException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientValidator {

	public static void clientValidator(ClientsModel newClient) throws Exception {

		if(newClient.getName().length()<3){
			log.info("El nombre ingresado es muy corto");
			throw new TooShortException("El nombre ingresado es muy corto");
		}
		if(newClient.getLastname().length()<3){
			log.info("El apellido ingresado es muy corto");
			throw new TooShortException("El apellido ingresado es muy corto");
		}
		if(newClient.getDocNumber().length()<6){
			log.info("El número de documento ingresado es muy corto");
			throw new TooShortException("El número de documento ingresado es muy corto");
		}
		if(newClient.getName().isEmpty()){
			log.info("El nombre no puede estar vacío");
			throw new NullException("El nombre no puede estar vacío");
		}
		if(newClient.getLastname().isEmpty()){
			log.info("El apellido no puede estar vacío");
			throw new NullException("El apellido no puede estar vacío");
		}
		if(newClient.getDocNumber().isEmpty()){
			log.info("El número de documento no puede estar vacío");
			throw new NullException("El número de documento no puede estar vacío");
		}

	}
}
