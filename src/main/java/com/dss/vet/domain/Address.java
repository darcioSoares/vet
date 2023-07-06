package com.dss.vet.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.dss.vet.dtos.AddressDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "address_id")
	private Integer id;
	private String road;
	private String number; 
	private String zipCode;
	private String state;
	private String contactPhone;
	
	@JsonIgnore
	@OneToOne()
	@JoinColumn(name = "client_id")
	private Client client;
	
	public Address() {
		super();
	}	
		
	
	public Address(AddressDto objDto) {
		super();
		this.id = objDto.getId();
		this.road = objDto.getRoad();
		this.number = objDto.getNumber();
		this.zipCode = objDto.getZipCode();
		this.state = objDto.getState();
		this.contactPhone = objDto.getContactPhone();
		
	}
	
	public Address(Integer id, Address objDto) {
		super();
		this.id = objDto.getId();
		this.road = objDto.getRoad();
		this.number = objDto.getNumber();
		this.zipCode = objDto.getZipCode();
		this.state = objDto.getState();
		this.contactPhone = objDto.getContactPhone();
		
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	
	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
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
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
