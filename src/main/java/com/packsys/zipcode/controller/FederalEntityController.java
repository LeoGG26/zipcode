package com.packsys.zipcode.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packsys.zipcode.dto.FederalEntityDto;
import com.packsys.zipcode.entity.FederalEntity;
import com.packsys.zipcode.service.ZipcodeService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/federal-entities")
@RequiredArgsConstructor
public class FederalEntityController {

    private final ZipcodeService service;

    @GetMapping
    public List<FederalEntity> findAll() {
        return service.getFederalEntities();
    }


    @GetMapping("/{id}/details")
    public FederalEntityDto getDetails(
            @PathVariable Long id) {

        return service.getFederalEntityDetails(id);
    }
}
