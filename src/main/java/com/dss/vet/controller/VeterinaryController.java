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

import com.dss.vet.domain.Veterinary;
import com.dss.vet.dtos.VeterinaryDto;
import com.dss.vet.services.VeterinaryService;

@RestController
@RequestMapping("/veterinary")
public class VeterinaryController {
	
	@Autowired
	private VeterinaryService veterinaryService;
	
	@GetMapping
	public ResponseEntity<List<VeterinaryDto>> list() {
		List<Veterinary> result = veterinaryService.findAll();
		return ResponseEntity.ok().body(result.stream().map(vet -> new VeterinaryDto(vet)).collect(Collectors.toList()));		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VeterinaryDto> veterinary(@PathVariable Integer id){
		Optional<Veterinary> vet = veterinaryService.findById(id);
		if(vet.isPresent()) {			
			return ResponseEntity.ok().body(new VeterinaryDto(vet));
		}
		//dessa forma estou enviando um Objeto com os campos NULL
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new VeterinaryDto());
	}
	
	@PostMapping
	public ResponseEntity<VeterinaryDto> create(@RequestBody @Valid VeterinaryDto objDto){
		Veterinary veterinary = veterinaryService.create(objDto);
		
		return ResponseEntity.ok().body(new VeterinaryDto(veterinary));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<VeterinaryDto> update(@PathVariable Integer id, @RequestBody @Valid VeterinaryDto objDto){
		Veterinary vet = veterinaryService.update(id, objDto);
		return ResponseEntity.status(HttpStatus.OK).body(new VeterinaryDto(vet));
	}

}
