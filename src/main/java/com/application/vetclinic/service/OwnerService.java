package com.application.vetclinic.service;

import com.application.vetclinic.dto.OwnerAndPetData;
import com.application.vetclinic.dto.OwnerData;
import com.application.vetclinic.dto.OwnerRegistrationData;
import com.application.vetclinic.model.Owner;
import com.application.vetclinic.repository.IOwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerService implements IOwnerService{

    private final IOwnerRepository ownerRepository;

    @Override
    public Long createOwner(OwnerRegistrationData ownerRegistrationData) {
        Owner owner = new Owner(ownerRegistrationData);
        ownerRepository.save(owner);
        return owner.getId();
    }

    @Override
    public OwnerData getOwner(Long id) {
        Owner owner = ownerRepository.getReferenceById(id);
        return new OwnerData(owner);
    }

    @Override
    public Page<OwnerData> getOwnersPage(Pageable pageable) {
        List<OwnerData> listOwnersData = ownerRepository.findAll()
                                                       .stream()
                                                       .map(OwnerData::new)
                                                       .toList();
        return new PageImpl<>(listOwnersData, pageable, listOwnersData.size());
    }

    @Override
    public Long updateOwner(OwnerData ownerData) {
        Owner owner = ownerRepository.getReferenceById(ownerData.id());
        owner.updateData(ownerData);
        return owner.getId();
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public OwnerAndPetData getOwnerWithPet(Long id) {
        Owner owner = ownerRepository.getReferenceById(id);
        return new OwnerAndPetData(owner);
    }
}
