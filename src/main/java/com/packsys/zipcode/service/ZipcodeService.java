package com.packsys.zipcode.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.packsys.zipcode.dto.FederalEntityDto;
import com.packsys.zipcode.dto.MunicipalityDto;
import com.packsys.zipcode.dto.NeighborhoodDto;
import com.packsys.zipcode.dto.ZipCodeDto;
import com.packsys.zipcode.entity.FederalEntity;
import com.packsys.zipcode.entity.Municipality;
import com.packsys.zipcode.entity.Neighborhood;
import com.packsys.zipcode.entity.ZipCode;

@Service
public class ZipcodeService {

    // private final List<FederalEntity> federalEntities = new ArrayList<>();
    // private final List<Municipality> municipalities = new ArrayList<>();
    // private final List<ZipCode> zipCodes = new ArrayList<>();
    // private final List<Neighborhood> neighborhoods = new ArrayList<>();

    private final List<FederalEntity> federalEntities;
    private final List<Municipality> municipalities;
    private final List<ZipCode> zipCodes;
    private final List<Neighborhood> neighborhoods;

    public ZipcodeService() {
        federalEntities = new ArrayList<>();
        municipalities = new ArrayList<>();
        zipCodes = new ArrayList<>();
        neighborhoods = new ArrayList<>();

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

    public FederalEntityDto getFederalEntityDetails(Long federalEntityId) {

    FederalEntity federalEntity = federalEntities.stream()
            .filter(fe -> fe.getId().equals(federalEntityId))
            .findFirst()
            .orElseThrow(() ->
                    new RuntimeException("Federal Entity not found"));

    List<MunicipalityDto> municipalityResponses =
            municipalities.stream()
                    .filter(m -> m.getFederalEntityId()
                            .equals(federalEntityId))
                    .map(municipality -> {

                        List<ZipCodeDto> zipCodeResponses =
                                zipCodes.stream()
                                        .filter(zip ->
                                                zip.getMunicipalityId()
                                                        .equals(municipality.getId()))
                                        .map(zipCode -> {

                                            List<NeighborhoodDto> neighborhoodResponses =
                                                    neighborhoods.stream()
                                                            .filter(neighborhood ->
                                                                    neighborhood.getZipCodeId()
                                                                            .equals(zipCode.getId()))
                                                            .map(neighborhood ->
                                                                    new NeighborhoodDto(
                                                                            neighborhood.getId(),
                                                                            neighborhood.getNeighborhoodName()
                                                                    ))
                                                            .toList();

                                            return new ZipCodeDto(
                                                    zipCode.getId(),
                                                    zipCode.getZipCode(),
                                                    neighborhoodResponses
                                            );
                                        })
                                        .toList();

                        return new MunicipalityDto(
                                municipality.getId(),
                                municipality.getMunicipalityName(),
                                zipCodeResponses
                        );
                    })
                    .toList();

    return new FederalEntityDto(
            federalEntity.getId(),
            federalEntity.getFederalEntityName(),
            municipalityResponses
    );
}
}
