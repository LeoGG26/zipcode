package com.packsys.zipcode.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packsys.zipcode.entity.ZipCode;
import com.packsys.zipcode.service.ZipcodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/zip-codes")
@RequiredArgsConstructor
public class ZipCodeController {

    private final ZipcodeService service;

    @GetMapping
    public List<ZipCode> findAll() {
        return service.getZipCodes();
    }
}
