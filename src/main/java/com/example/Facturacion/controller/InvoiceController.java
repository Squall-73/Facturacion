package com.example.Facturacion.controller;

import com.example.Facturacion.entities.InvoiceModel;
import com.example.Facturacion.exception.AlreadyExistsException;
import com.example.Facturacion.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="api/invoice")
public class InvoiceController {


	@Autowired
	private InvoiceService invoiceService;

	@PostMapping(path = "/")
	public ResponseEntity<InvoiceModel> create(@RequestBody InvoiceModel invoice) throws AlreadyExistsException {
		return new ResponseEntity<>(this.invoiceService.create(invoice), HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<InvoiceModel> update(@RequestBody InvoiceModel invoice, @PathVariable Long id) throws Exception {
		return new ResponseEntity<>(this.invoiceService.update(invoice,id), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<InvoiceModel> findById(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(this.invoiceService.findById(id), HttpStatus.OK);
	}

	@GetMapping(path = "/")
	public ResponseEntity<List<InvoiceModel>> findAll(){
		return new ResponseEntity<>(this.invoiceService.findAll(), HttpStatus.OK);
	}



}
