package com.application.vetclinic.service;

import com.application.vetclinic.dto.PetData;
import com.application.vetclinic.dto.PetRegistrationData;
import com.application.vetclinic.model.Pet;
import com.application.vetclinic.repository.IPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService implements IPetService {

    private final IPetRepository petRepository;

    @Override
    public Long createPet(PetRegistrationData petRegistrationData) {
        Pet pet = new Pet(petRegistrationData);
        petRepository.save(pet);
        return pet.getId();
    }

    @Override
    public PetData getPet(Long id) {
        return new PetData(petRepository.getReferenceById(id));
    }

    @Override
    public Page<PetData> getPetsPage(Pageable pageable) {
        List<PetData> listPetsPage = petRepository.findAll()
                                                  .stream()
                                                  .map(PetData::new)
                                                  .toList();
        return new PageImpl<>(listPetsPage, pageable, listPetsPage.size());
    }

    @Override
    public Long updatePet(PetData petData) {
        Pet pet = petRepository.getReferenceById(petData.id());
        pet.updateData(petData);
        return pet.getId();
    }

    @Override
    public void deletePet(Long id) {
        Pet pet = petRepository.getReferenceById(id);
        petRepository.delete(pet);
    }
}
