package com.application.vetclinic.controller;

import com.application.vetclinic.dto.OwnerData;
import com.application.vetclinic.dto.OwnerRegistrationData;
import com.application.vetclinic.service.IOwnerService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerController {

    private final IOwnerService ownerService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<OwnerData> createOwner(@RequestBody @Valid
                                                                 OwnerRegistrationData ownerRegistrationData) {
        Long id = ownerService.createOwner(ownerRegistrationData);
        return ResponseEntity.ok(getOwner(id)).getBody();
    }

    @GetMapping("/get")
    public ResponseEntity<OwnerData> getOwner(@RequestParam Long id) {
        return ResponseEntity.ok(ownerService.getOwner(id));
    }

    @GetMapping("/get/page")
    public ResponseEntity<Page<OwnerData>> getOwnersPage(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(ownerService.getOwnersPage(pageable));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<OwnerData> updateOwner(@RequestBody @Valid OwnerData ownerData) {
        Long id = ownerService.updateOwner(ownerData);
        return ResponseEntity.ok(getOwner(id).getBody());
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return ResponseEntity.noContent().build();
    }

}
