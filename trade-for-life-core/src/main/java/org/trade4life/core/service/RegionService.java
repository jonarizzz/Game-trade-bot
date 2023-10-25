package org.trade4life.core.service;

import org.trade4life.core.model.RegionModel;
import org.trade4life.core.web.dto.login.GetRegionsResponseDto;

import java.util.Optional;

public interface RegionService {

    GetRegionsResponseDto findAll();

    Optional<RegionModel> findRegionById(Long id);

}
