package com.packsys.zipcode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZipCode {

    private Long id;
    private Long municipalityId;
    private String zipCode;
}