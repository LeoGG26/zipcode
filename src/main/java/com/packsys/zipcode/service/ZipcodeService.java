package com.packsys.zipcode.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.packsys.zipcode.entity.FederalEntity;
import com.packsys.zipcode.entity.Municipality;
import com.packsys.zipcode.entity.Neighborhood;
import com.packsys.zipcode.entity.ZipCode;

@Service
public class ZipcodeService {

    private final List<FederalEntity> federalEntities = new ArrayList<>();
    private final List<Municipality> municipalities = new ArrayList<>();
    private final List<ZipCode> zipCodes = new ArrayList<>();
    private final List<Neighborhood> neighborhoods = new ArrayList<>();

    public ZipcodeService() {

        federalEntities.add(
            new FederalEntity(1L, "Chiapas")
        );

        municipalities.add(
            new Municipality(1L, 1L, "Tapachula")
        );

        zipCodes.add(
            new ZipCode(1L, 1L, "30700")
        );

        neighborhoods.add(
            new Neighborhood(1L, 1L, "Centro")
        );

        neighborhoods.add(
            new Neighborhood(2L, 1L, "5 de Febrero")
        );
    }

    public List<FederalEntity> getFederalEntities() {
        return federalEntities;
    }

    public List<Municipality> getMunicipalities() {
        return municipalities;
    }

    public List<ZipCode> getZipCodes() {
        return zipCodes;
    }

    public List<Neighborhood> getNeighborhoods() {
        return neighborhoods;
    }
}
