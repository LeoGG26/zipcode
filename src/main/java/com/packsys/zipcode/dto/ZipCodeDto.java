package com.packsys.zipcode.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZipCodeDto {

    private Long id;
    private String zipCode;
    private List<NeighborhoodDto> neighborhoods;
}