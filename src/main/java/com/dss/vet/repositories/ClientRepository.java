package com.dss.vet.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dss.vet.domain.Client;

@Repository
@Transactional
public interface ClientRepository extends JpaRepository<Client, Integer>{

	Optional<Client> findByCpf(String cpf);

}
