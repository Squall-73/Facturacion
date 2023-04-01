package com.example.Facturacion.services;

import com.example.Facturacion.entities.InvoiceDetailsModel;
import com.example.Facturacion.entities.InvoiceModel;
import com.example.Facturacion.exception.IdNotValidException;
import com.example.Facturacion.exception.NotFoundException;
import com.example.Facturacion.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	//Método para crear nuevos invoice.
	public InvoiceModel create(InvoiceModel newInvoice)  {
			return this.invoiceRepository.save(newInvoice);
	}

	//Método para actualizar invoice, controla que el ID brindado es válido (positivo) y si existe en la base de datos, antes de intentar actualizar.
	public InvoiceModel update(InvoiceModel newInvoice, Long id) throws Exception {
		log.info("ID INGRESADO: " + id);
		if (id <= 0){
			throw new IdNotValidException("El id brindado no es valido.");
		}

		Optional<InvoiceModel> invoiceOp = this.invoiceRepository.findById(id);

		if (invoiceOp.isEmpty()){
			log.info("El invoice que intenta modificar no existe en la base de datos: " + newInvoice);
			throw new NotFoundException("El invoice que intenta modificar no existe en la base de datos.");
		}else {
			log.info("el invoice fue encontrado.");
			InvoiceModel invoiceBd = invoiceOp.get();

			invoiceBd.setCreated_at(newInvoice.getCreated_at());
			invoiceBd.setTotal(newInvoice.getTotal());
			invoiceBd.setClientsModel(newInvoice.getClientsModel());

			log.info("Invoice actualizado: " + invoiceBd);

			return this.invoiceRepository.save(invoiceBd);
		}

	}
	// Método para buscar un invoice en particular, con el ID.
	public InvoiceModel findById(Long id) throws Exception {
		if (id <= 0){
			throw new IdNotValidException("El id brindado no es valido.");
		}

		Optional<InvoiceModel> invoiceOp = this.invoiceRepository.findById(id);

		if (invoiceOp.isEmpty()){
			log.info("El invoice con el id brindado no existe en la base de datos: " + id);
			throw new NotFoundException("El invoice que intenta solicitar no existe.");
		}else {
			return invoiceOp.get();
		}
	}

	//Método para buscar todos los invoices.
	public List<InvoiceModel> findAll(){
		return this.invoiceRepository.findAll();
	}

	public InvoiceModel delete(Long id) throws Exception {
		if (id <= 0){
			throw new IdNotValidException("El id brindado no es valido.");
		}

		Optional<InvoiceModel> invoiceOp = this.invoiceRepository.findById(id);

		if (invoiceOp.isEmpty()){
			log.info("El invoice con el id brindado no existe en la base de datos: " + id);
			throw new NotFoundException("El invoice que intenta solicitar no existe.");
		}else {
			log.info("El Id Ingresado: " + id + " ha sido eliminado.");
			invoiceOp.get().setStatus(false);
			invoiceRepository.save(invoiceOp.get());
			return invoiceOp.get();
		}
	}


}



