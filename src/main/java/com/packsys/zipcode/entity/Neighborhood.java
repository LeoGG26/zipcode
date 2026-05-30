package com.packsys.zipcode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Neighborhood {

    private Long id;
    private Long zipCodeId;
    private String neighborhoodName;
}