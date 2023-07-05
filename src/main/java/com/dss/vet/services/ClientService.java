package com.dss.vet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		
		this.validationCpf(objDto);		
		//ao criar o cliente, ele já entra como ativo
		objDto.setStatus(Status.ATIVO);
		
		Client objClient = new Client(objDto);
		return repository.save(objClient);
	}
	
	public Client update(Integer id, ClientDto objDto) {
		
		Optional<Client> oldClient = repository.findById(id);
		if(oldClient.isEmpty()) {
			throw new DataIntegrityViolationException("Cliente não encontrado, update falhou!");
		}
		
		this.validationCpf(objDto);
		objDto.setId(id);
		Client client = new Client(objDto);
		Client result = repository.save(client);
		
		return result;		
	}

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Client findById(Integer id) {
		Optional<Client> result = repository.findById(id);
		return result.orElse(null);
	}	
	
	private void validationCpf(ClientDto objDto) {
		Optional<Client> resultCpf = repository.findByCpf(objDto.getCpf());
		
		//caso o cpf exista, verificar se e o mesmo id, para poder permitir o update
		if(resultCpf.isPresent() && resultCpf.get().getId() != objDto.getId()) {			
			throw new DataIntegrityViolationException("CPF já cadastrado");
		}
		
	};
	


}
