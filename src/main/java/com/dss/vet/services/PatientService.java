package com.dss.vet.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	public List<Patient> list() {
		List<Patient> result = repository.findAll();
		return result;
	}

	public  Patient findById(Integer id) {
		Optional<Patient> result = repository.findById(id);
		return result.orElse(null);
	}

	public Patient update(Integer id, @Valid PatientDto objDto) {
		Optional<Patient> result = repository.findById(id);
		if(result.isEmpty()) {
			throw new DataIntegrityViolationException("Paciente não encontrado, update falhou!");
		}
		
		Patient patient = new Patient(objDto);
		patient.setId(id);
		return repository.save(patient);
	}
	
}
