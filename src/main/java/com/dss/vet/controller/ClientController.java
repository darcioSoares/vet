package com.dss.vet.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public ResponseEntity<List<ClientDto>> index(){
		List<Client> listClient = clientService.findAll();
		//transformando dominio Client em um Objeto ClientDto
		List<ClientDto> listDto = listClient.stream().map(obj -> new ClientDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Integer id){
		
		Client client = clientService.findById(id);
		if(client == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não Encontrado");
		}
		
		return ResponseEntity.ok().body(new ClientDto(client));
	}	

	@PostMapping
	public ResponseEntity<ClientDto> create(@Valid @RequestBody ClientDto objDto){
		Client client = clientService.create(objDto);		
		return ResponseEntity.ok().body(new ClientDto(client));
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDto> update(@PathVariable Integer id, @Valid @RequestBody ClientDto objDto){
			Client client = clientService.update(id, objDto);
			return ResponseEntity.ok().body(new ClientDto(client));
	}
	
		

}
