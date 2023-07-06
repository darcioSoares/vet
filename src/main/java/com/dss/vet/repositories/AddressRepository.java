package com.dss.vet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dss.vet.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
