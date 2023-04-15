package com.example.Facturacion.services;

import com.example.Facturacion.entities.InvoiceDetailsModel;
import com.example.Facturacion.exception.NotFoundException;
import com.example.Facturacion.repository.InvoiceDetailsRepository;
import com.example.Facturacion.repository.InvoiceRepository;
import com.example.Facturacion.validator.InvoiceDetailsValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Slf4j
@Service
public class InvoiceDetailsService {

	@Autowired
	private InvoiceDetailsRepository invoiceDetailsRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	//Método para crear nuevos invoice details.
	public InvoiceDetailsModel create(InvoiceDetailsModel newInvoiceDetail) throws Exception {


			newInvoiceDetail.setInvoice(invoiceRepository.findById(newInvoiceDetail.getInvoiceId()).orElseThrow(() ->new NotFoundException("El invoice seleccionado no existe.")));

			double actualPrice = newInvoiceDetail.getProduct().getPrice();

			newInvoiceDetail.setProductPrice(actualPrice);

			newInvoiceDetail.setPrice(actualPrice * newInvoiceDetail.getAmount());

			InvoiceDetailsValidator.invoiceDetailsValidator(newInvoiceDetail);


			return this.invoiceDetailsRepository.save(newInvoiceDetail);

	}



}
