package com.application.vetclinic.service;

import com.application.vetclinic.dto.PetData;
import com.application.vetclinic.dto.PetRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPetService {
    public Long createPet(PetRegistrationData petRegistrationData);
    public PetData getPet(Long id);
    public Page<PetData> getPetsPage(Pageable pageable);
    public Long updatePet(PetData petData);
    public void deletePet(Long id);
}
