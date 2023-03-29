package com.example.Facturacion.controller;

import com.example.Facturacion.entities.InvoiceDetailsModel;
import com.example.Facturacion.services.InvoiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="api/invoice/detail")
public class InvoiceDetailController {

	@Autowired
	private InvoiceDetailsService invoiceDetailsService;
	@PostMapping(path = "/")
	public ResponseEntity<InvoiceDetailsModel> create(@RequestBody InvoiceDetailsModel invoice) {
		return new ResponseEntity<>(this.invoiceDetailsService.create(invoice), HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<InvoiceDetailsModel> update(@RequestBody InvoiceDetailsModel invoice, @PathVariable Long id) throws Exception {
		return new ResponseEntity<>(this.invoiceDetailsService.update(invoice,id), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<InvoiceDetailsModel> findById(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(this.invoiceDetailsService.findById(id), HttpStatus.OK);
	}

	@GetMapping(path = "/")
	public ResponseEntity<List<InvoiceDetailsModel>> findAll(){
		return new ResponseEntity<>(this.invoiceDetailsService.findAll(), HttpStatus.OK);
	}


}
