package com.dss.vet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping
	public ResponseEntity<PatientDto> create(@RequestBody @Valid PatientDto objDto){
		
		Patient patient = patientService.create(objDto);
		
		return ResponseEntity.ok().body(new PatientDto(patient));
		
	}

}
