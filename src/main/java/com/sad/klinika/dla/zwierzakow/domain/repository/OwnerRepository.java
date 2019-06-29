package com.sad.klinika.dla.zwierzakow.domain.repository;

import com.sad.klinika.dla.zwierzakow.domain.entity.OwnerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OwnerRepository extends CrudRepository<OwnerEntity, Long> {

    List<OwnerEntity> findByFirstNameOrLastNameContaining(String firstName, String lastName);


}
