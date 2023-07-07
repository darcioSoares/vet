package com.dss.vet.dtos;

import com.dss.vet.domain.Address;

public class AddressDto {	
	
	private Integer id;
	private String road;
	private String number; 
	private String zipCode;
	private String state;
	private String contactPhone;	
	
		
	public AddressDto() {
		super();
	}
	
	public AddressDto(Address ObjAddress) {
		super();
		this.id = ObjAddress.getId();
		this.road = ObjAddress.getRoad();
		this.number = ObjAddress.getNumber();
		this.zipCode = ObjAddress.getZipCode();
		this.state = ObjAddress.getState();
		this.contactPhone = ObjAddress.getContactPhone();		
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

	
	
	
}
