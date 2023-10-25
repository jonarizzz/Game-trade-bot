package org.trade4life.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.trade4life.core.converter.RegionMapper;
import org.trade4life.core.model.RegionModel;
import org.trade4life.core.repository.RegionRepository;
import org.trade4life.core.service.RegionService;
import org.trade4life.core.web.dto.login.GetRegionsResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository repository;
    private final RegionMapper mapper;

    @Override
    public GetRegionsResponseDto findAll() {
        List<RegionModel> regions = (List<RegionModel>) repository.findAll();
        return GetRegionsResponseDto.builder()
            .regions(regions.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList()))
            .build();
    }

    @Override
    public Optional<RegionModel> findRegionById(Long id) {
        return repository.findById(id);
    }
}
