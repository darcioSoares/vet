package com.dss.vet.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dss.vet.domain.enums.TypeAnimal;
import com.dss.vet.dtos.PatientDto;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Patient implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String breend;
	private TypeAnimal animal;
	private String birthDate; 
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate created_at = LocalDate.now();	
	
	public Patient() {
		super();
	}
			
	public Patient(PatientDto objDto) {
		super();
		this.id = objDto.getId();
		this.name = objDto.getName();
		this.breend = objDto.getBreend();
		this.animal = objDto.getAnimal();
		this.birthDate = objDto.getBirthDate();
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
		Patient other = (Patient) obj;
		return Objects.equals(id, other.id);
	}
		
	
}
