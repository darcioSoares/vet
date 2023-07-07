package com.dss.vet.dtos;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import com.dss.vet.domain.Veterinary;
import com.dss.vet.domain.enums.Status;

public class VeterinaryDto {
	
	private Integer id;
	@NotBlank(message = "Campo Nome Preenchimento Obrigatorio")
	private String name;
	@NotBlank(message = "Campo Sobre Nome Preenchimento Obrigatorio")
	private String lastName;
	@NotBlank(message = "Campo CPF Preenchimento Obrigatorio")
	private String cpf;
	private Status status;
	
				
	public VeterinaryDto() {
		super();
	}
	
	public VeterinaryDto(Veterinary obj) {		
		this.id = obj.getId();
		this.name = obj.getName();
		this.lastName = obj.getName();
		this.cpf = obj.getCpf();
		this.status = obj.getStatus();
	}
	
	public VeterinaryDto(Optional<Veterinary> obj) {		
		this.id = obj.get().getId();
		this.name = obj.get().getName();
		this.lastName = obj.get().getName();
		this.cpf = obj.get().getCpf();
		this.status = obj.get().getStatus();
	}
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
		

}
