package com.ndirangu.petlover.repository;

import com.ndirangu.petlover.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
    Vet findByLastName(String lastName);
}
