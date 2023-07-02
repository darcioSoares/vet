package com.dss.vet.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dss.vet.domain.Patient;

@Repository
@Transactional
public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
