package com.application.vetclinic.controller;

import com.application.vetclinic.dto.PetData;
import com.application.vetclinic.dto.PetRegistrationData;
import com.application.vetclinic.service.IPetService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {

    private final IPetService petService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<PetData> createPet(@RequestBody @Valid PetRegistrationData petRegistrationData) {
        Long id = petService.createPet(petRegistrationData);
        return ResponseEntity.ok(this.getPet(id).getBody());
    }

    @GetMapping("/get")
    public ResponseEntity<PetData> getPet(@RequestParam Long id) {
        return ResponseEntity.ok(petService.getPet(id));
    }

    @GetMapping("/get/page")
    public ResponseEntity<Page<PetData>> getPetsPage(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(petService.getPetsPage(pageable));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<PetData> updatePet(@RequestBody @Valid PetData petData) {
        Long id = petService.updatePet(petData);
        return ResponseEntity.ok(this.getPet(id).getBody());
    }

    @DeleteMapping("/delete")
    @Transactional
    public ResponseEntity deletePet(@RequestParam Long id) {
        petService.deletePet(id);
        return ResponseEntity.ok().build();
    }
}
