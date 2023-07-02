package com.dss.vet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dss.vet.domain.Patient;
import com.dss.vet.dtos.PatientDto;
import com.dss.vet.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repository;
	
	public Patient create(PatientDto objDto) {
		Patient patient = new Patient(objDto);
		return repository.save(patient);
	}
	
}
