package com.dss.vet.dtos;

import javax.validation.constraints.NotNull;

import com.dss.vet.domain.Client;
import com.dss.vet.domain.enums.Status;

public class ClientDto {
	
	private Integer id;
	@NotNull(message = "Campo CPF Preenchimento Obrigatorio")
	private String cpf;
	@NotNull(message = "Campo Name Preenchimento Obrigatorio")	
	private String name;
	@NotNull(message = "Campo LastName Preenchimento Obrigatorio")
	private String lastName;
	
	private Status status;
		
	public ClientDto() {
		super();
	}
	
	public ClientDto(Client objClient ) {
		super();
		this.id = objClient.getId();
		this.cpf = objClient.getCpf();
		this.name = objClient.getName();
		this.lastName = objClient.getLastName();
		this.status = objClient.getStatus();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	

}
