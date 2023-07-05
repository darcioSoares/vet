package com.dss.vet.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dss.vet.domain.Patient;
import com.dss.vet.dtos.PatientDto;
import com.dss.vet.services.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public ResponseEntity<List<PatientDto>> list(){
		List<Patient> patient = patientService.list();
		List<PatientDto> patientDto = patient.stream().map(obj -> new PatientDto(obj)).collect(Collectors.toList());		
		return ResponseEntity.ok().body(patientDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Integer id){
		Patient patient = patientService.findById(id);
		
		if(patient == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Paciente não foi encontrado!");
		}
		return ResponseEntity.ok().body(new PatientDto(patient));				
	}	
	
	
	@PostMapping
	public ResponseEntity<PatientDto> create(@RequestBody @Valid PatientDto objDto){
		
		Patient patient = patientService.create(objDto);
		
		return ResponseEntity.ok().body(new PatientDto(patient));
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PatientDto> update(@PathVariable Integer id, @Valid @RequestBody PatientDto objDto){
		Patient patient = patientService.update(id, objDto);		
		return ResponseEntity.ok().body(new PatientDto(patient));
	}

}
