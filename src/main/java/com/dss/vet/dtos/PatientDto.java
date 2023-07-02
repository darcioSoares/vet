package com.dss.vet.dtos;

import javax.validation.constraints.NotNull;

import com.dss.vet.domain.Patient;
import com.dss.vet.domain.enums.TypeAnimal;

public class PatientDto {
		
	private Integer id;
	@NotNull(message = "Campo Nome Preenchimento Obrigatorio")
	private String name;
	@NotNull(message = "Campo Raça Preenchimento Obrigatorio")
	private String breend;
	@NotNull(message = "Campo Animal Preenchimento Obrigatorio")
	private TypeAnimal animal;
	@NotNull(message = "Campo Data nascimento Preenchimento Obrigatorio")
	private String birthDate; 
	
	public PatientDto() {
		super();
	}
	
	public PatientDto(Patient obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.breend = obj.getBreend();
		this.animal = obj.getAnimal();
		this.birthDate = obj.getBirthDate();
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

	public String getBreend() {
		return breend;
	}

	public void setBreend(String breend) {
		this.breend = breend;
	}

	public TypeAnimal getAnimal() {
		return animal;
	}

	public void setAnimal(TypeAnimal animal) {
		this.animal = animal;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	

}
