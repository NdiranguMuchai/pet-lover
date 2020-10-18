package com.ndirangu.petlover.service;


import com.ndirangu.petlover.model.Owner;

import java.util.List;

public interface OwnerService  extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);


}
