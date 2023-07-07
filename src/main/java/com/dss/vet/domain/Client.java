package com.dss.vet.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import com.dss.vet.domain.enums.Status;
import com.dss.vet.dtos.ClientDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer id;
	
	@Column(unique = true)
	private String cpf;
	
	private String name;
	private String lastName;
	private Status status;
	
	@Valid
	@JsonIgnore
	@OneToOne(mappedBy = "client")
	private Address address;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate created_at = LocalDate.now();
	
	
	public Client() {
		super();
	}
	
	public Client(Integer id, String cpf, String name, String lastName) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.lastName = lastName;		
	}

	public Client(ClientDto objDto) {
		super();
		this.id = objDto.getId();
		this.cpf = objDto.getCpf();
		this.name = objDto.getName();
		this.lastName = objDto.getLastName();
		this.status = objDto.getStatus();			
	}
	

	public Integer getId() {
		return id;
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
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setId(Integer id) {
		this.id = id;
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
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
