package com.packsys.zipcode.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FederalEntityDto {

    private Long id;
    private String federalEntityName;
    private List<MunicipalityDto> municipalities;
}
