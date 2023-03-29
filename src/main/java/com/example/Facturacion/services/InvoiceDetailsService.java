package com.example.Facturacion.services;

import com.example.Facturacion.entities.InvoiceDetailsModel;
import com.example.Facturacion.exception.IdNotValidException;
import com.example.Facturacion.exception.NotFoundException;
import com.example.Facturacion.repository.InvoiceDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InvoiceDetailsService {

	@Autowired
	private InvoiceDetailsRepository invoiceDetailsRepository;


	//Método para crear nuevos invoice details.
	public InvoiceDetailsModel create(InvoiceDetailsModel newInvoiceDetail) {

			return this.invoiceDetailsRepository.save(newInvoiceDetail);

	}
	//Método para actualizar invoice details, controla que el ID brindado es válido (positivo) y si existe en la base de datos, antes de intentar actualizar.
	public InvoiceDetailsModel update(InvoiceDetailsModel newInvoiceDetail, Long id) throws Exception {
		log.info("ID INGRESADO: " + id);
		if (id <= 0){
			throw new IdNotValidException("El id brindado no es valido.");
		}

		Optional<InvoiceDetailsModel> invoiceDetailOp = this.invoiceDetailsRepository.findById(id);

		if (invoiceDetailOp.isEmpty()){
			log.info("El invoice details que intenta modificar no existe en la base de datos: " + newInvoiceDetail);
			throw new NotFoundException("El invoice details que intenta modificar no existe en la base de datos.");
		}else {
			log.info("El invoice detail fue encontrado.");
			InvoiceDetailsModel invoiceDetailBd = invoiceDetailOp.get();

			invoiceDetailBd.setProduct(newInvoiceDetail.getProduct());
			invoiceDetailBd.setAmount(newInvoiceDetail.getAmount());
			invoiceDetailBd.setPrice(newInvoiceDetail.getPrice());
			invoiceDetailBd.setInvoiceModel(newInvoiceDetail.getInvoiceModel());

			log.info("Invoice detail actualizado: " + invoiceDetailBd);

			return this.invoiceDetailsRepository.save(invoiceDetailBd);
		}
	}

	// Método para buscar un invoice detail en particular, con el ID.
	public InvoiceDetailsModel findById(Long id) throws Exception {
		if (id <= 0){
			throw new IdNotValidException("El id brindado no es válido.");
		}

		Optional<InvoiceDetailsModel> invoiceDetailOp = this.invoiceDetailsRepository.findById(id);

		if (invoiceDetailOp.isEmpty()){
			log.info("El invoice detail con el id brindado no existe en la base de datos: " + id);
			throw new NotFoundException("El invoice detail que intenta solicitar no existe.");
		}else {
			return invoiceDetailOp.get();
		}
	}
	//Método para buscar todos los invoice details.
	public List<InvoiceDetailsModel> findAll(){
		return this.invoiceDetailsRepository.findAll();
	}

}
