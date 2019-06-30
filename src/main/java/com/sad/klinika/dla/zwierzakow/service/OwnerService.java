package com.sad.klinika.dla.zwierzakow.service;

import com.sad.klinika.dla.zwierzakow.domain.entity.OwnerEntity;
import com.sad.klinika.dla.zwierzakow.domain.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

//    public void createOwner(OwnerEntity ownerEntity){
//        ownerRepository.save(ownerEntity);
//    }
//
//    public Iterable<OwnerEntity> getAllOwners(){ //dlaczego z Listą nie działa???
//        return ownerRepository.findAll();
//    }

    public Optional<OwnerEntity> findById(Long ownerId){
        return ownerRepository.findById(ownerId);
    }
}
