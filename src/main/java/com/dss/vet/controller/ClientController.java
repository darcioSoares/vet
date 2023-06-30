package com.dss.vet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dss.vet.domain.Client;
import com.dss.vet.dtos.ClientDto;
import com.dss.vet.services.ClientService;

@RestController
@RequestMapping(value = "client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
//	@GetMapping
//	public ResponseEntity<Object> index(){}

	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody ClientDto objDto){
		Client client = clientService.create(objDto);		
		return ResponseEntity.ok().body(client);
		
	}

}
