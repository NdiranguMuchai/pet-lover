package com.ndirangu.petlover.service;


import com.ndirangu.petlover.model.Vet;

public interface VetService extends CrudService<Vet, Long>{
    Vet findByLastName(String lastName);
}
