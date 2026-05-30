package com.packsys.zipcode.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Municipality {

    private Long id;
    private Long federalEntityId;
    private String municipalityName;
}
