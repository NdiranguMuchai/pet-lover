package com.ndirangu.petlover.repository;

import com.ndirangu.petlover.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
