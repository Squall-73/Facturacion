package com.example.Facturacion.validator;

import com.example.Facturacion.entities.InvoiceModel;
import com.example.Facturacion.exception.MinException;
import com.example.Facturacion.exception.NullException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvoiceValidator {

	public static void invoiceValidator(InvoiceModel newInvoice) throws Exception{

		if(newInvoice.getCreated_at() == null){
			log.info("La fecha de creación no puede estar vacía");
			throw new NullException("La fecha de creación no puede estar vacía");
		}
		if(newInvoice.getTotal()==null){
			log.info("El total no puede estar vacío");
			throw new NullException("El total no puede estar vacío");
		}
		if(newInvoice.getTotal()<0){
			log.info("El total no puede ser un número negativo");
			throw new MinException("El total no puede ser un número negativo");
		}
	}
}
