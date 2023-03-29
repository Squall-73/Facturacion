package com.example.Facturacion.controller;

import com.example.Facturacion.entities.ClientsModel;
import com.example.Facturacion.exception.AlreadyExistsException;
import com.example.Facturacion.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="api/clients")
public class ClientsController {


	@Autowired
	private ClientsService clientsService;

	@PostMapping(path = "/")
	public ResponseEntity<ClientsModel> create(@RequestBody ClientsModel client) throws AlreadyExistsException {
		return new ResponseEntity<>(this.clientsService.create(client), HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<ClientsModel> update(@RequestBody ClientsModel client, @PathVariable Long id) throws Exception {
		return new ResponseEntity<>(this.clientsService.update(client,id), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<ClientsModel> findById(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(this.clientsService.findById(id), HttpStatus.OK);
	}

	@GetMapping(path = "/")
	public ResponseEntity<List<ClientsModel>> findAll(){
		return new ResponseEntity<>(this.clientsService.findAll(), HttpStatus.OK);
	}


}
