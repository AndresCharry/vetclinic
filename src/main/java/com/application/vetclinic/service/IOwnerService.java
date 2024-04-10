package com.application.vetclinic.service;

import com.application.vetclinic.dto.OwnerData;
import com.application.vetclinic.dto.OwnerRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOwnerService {
    public Long createOwner(OwnerRegistrationData ownerRegistrationData);
    public OwnerData getOwner(Long id);
    public Page<OwnerData> getOwnersPage(Pageable pageable);
}
