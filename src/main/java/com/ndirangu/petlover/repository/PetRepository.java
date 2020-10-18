package com.ndirangu.petlover.repository;

import com.ndirangu.petlover.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
