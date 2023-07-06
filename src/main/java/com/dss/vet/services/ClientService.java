package com.dss.vet.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dss.vet.domain.Address;
import com.dss.vet.domain.Client;
import com.dss.vet.domain.enums.Status;
import com.dss.vet.dtos.AddressDto;
import com.dss.vet.dtos.ClientDto;
import com.dss.vet.repositories.AddressRepository;
import com.dss.vet.repositories.ClientRepository;

@Service
@Transactional
public class ClientService {
	
	@Autowired
	private ClientRepository ClientRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	public void teste(ClientDto objDto) {
		
		System.out.println("ClientService.teste(ClientDto)");
		
		AddressDto address = new AddressDto(objDto.getAddress());
		
		
		this.test( address);
	}
	
	public void test( @Valid AddressDto objDto) {
		
		System.out.println(objDto.getRoad());
	}
	
	public Client create(ClientDto objDto) {
		
		this.validationCpf(objDto);		
		//ao criar o cliente, já entra como ativo
		objDto.setStatus(Status.ATIVO);
		
		Client objClient = new Client(objDto);		
		Client client = ClientRepository.save(objClient);

				
		objDto.getAddress().setClient(client);		
		Address address = addressRepository.save(objDto.getAddress());		
			
		client.setAddress(address);

		return client;
		
	}
	
	
	public Client update(Integer id, ClientDto objDto) {
		
		Optional<Client> oldClient = ClientRepository.findById(id);
		if(oldClient.isEmpty()) {
			throw new DataIntegrityViolationException("Cliente não encontrado, update falhou!");
		}
		
		this.validationCpf(objDto);
		objDto.setId(id);
		Client client = new Client(objDto);
						
		Client result = ClientRepository.save(client);
		
//		//salved address
		Address address = addressRepository.save(objDto.getAddress());
		
		result.setAddress(address);
		
		return result;		
	}
	

	public List<Client> findAll() {
		return ClientRepository.findAll();
	}

	public Client findById(Integer id) {
		Optional<Client> result = ClientRepository.findById(id);
		return result.orElse(null);
	}	
	
	private void validationCpf(ClientDto objDto) {
		Optional<Client> resultCpf = ClientRepository.findByCpf(objDto.getCpf());
		
		//caso o cpf exista, verificar se e o mesmo id, para poder permitir o update
		if(resultCpf.isPresent() && resultCpf.get().getId() != objDto.getId()) {			
			throw new DataIntegrityViolationException("CPF já cadastrado");
		}
		
	};
	


}
