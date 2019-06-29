package com.sad.klinika.dla.zwierzakow.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //musieliśmy dopisać strategy, ponieważ dodaliśmy już kilku włascicieli w data.sql
    private Long id;


    private String firstName;
    private String lastName;
    private String city;
    private String address;
    private String telephoneNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ownerEntity")
    private List<PetEntity> pets;


}
