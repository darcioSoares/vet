package com.dss.vet.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dss.vet.domain.Client;
import com.dss.vet.domain.enums.Status;
import com.dss.vet.dtos.ClientDto;
import com.dss.vet.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client create(ClientDto objDto) {
		
		objDto.setStatus(Status.CANCELADO);
		
		Client objClient = new Client(objDto);
		return repository.save(objClient);
	}

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Client findById(Integer id) {
		Optional<Client> result = repository.findById(id);
		return result.orElse(null);
	}

	public Client update(Integer id, ClientDto objDto) {
		objDto.setId(id);
		Client client = new Client(objDto);
		Client result = repository.save(client);
		
		return result;
		
	}

}
