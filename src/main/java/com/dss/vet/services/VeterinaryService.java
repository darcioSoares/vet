package com.dss.vet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dss.vet.domain.Veterinary;
import com.dss.vet.dtos.VeterinaryDto;
import com.dss.vet.repositories.VeterinayRepository;

@Transactional
@Service
public class VeterinaryService {
	
	@Autowired
	private VeterinayRepository veterinaryRepository;

	public Veterinary create(VeterinaryDto objDto) {
		Veterinary veterinary = new Veterinary(objDto);
		
		Veterinary result = veterinaryRepository.save(veterinary);
				
		return result;
	}

	public List<Veterinary> findAll() {
		List<Veterinary> result = veterinaryRepository.findAll();
		return result;
	}

	public Optional<Veterinary> findById(Integer id) {
		Optional<Veterinary> result = veterinaryRepository.findById(id);
		return result;
	}

	public Veterinary update(Integer id, VeterinaryDto objDto) {
		Optional<Veterinary> resultVet = veterinaryRepository.findById(id);
		if(resultVet.isEmpty()) {
			throw new RuntimeException("Id não encontrado");
		}
		Veterinary vet = new Veterinary(objDto);
		vet.setId(id);
		Veterinary result = veterinaryRepository.save(vet);
		return result;
	}

}
