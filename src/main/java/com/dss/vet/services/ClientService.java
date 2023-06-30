package com.dss.vet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dss.vet.domain.Client;
import com.dss.vet.dtos.ClientDto;
import com.dss.vet.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client create(ClientDto objDto) {
		
		Client objClient = new Client(objDto);
		return repository.save(objClient);
	}

}
