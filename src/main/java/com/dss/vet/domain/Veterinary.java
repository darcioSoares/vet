package com.dss.vet.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dss.vet.domain.enums.Status;
import com.dss.vet.dtos.VeterinaryDto;

@Entity
public class Veterinary implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String lastName;
	private String cpf;
	private Status status;
	
			
	public Veterinary() {
		super();
	}

	public Veterinary(VeterinaryDto objDto ) {
		this.id = objDto.getId();
		this.name = objDto.getName();
		this.lastName = objDto.getLastName();
		this.cpf = objDto.getCpf();
		this.status = objDto.getStatus();
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


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veterinary other = (Veterinary) obj;
		return Objects.equals(id, other.id);
	}
	
	
		
}
