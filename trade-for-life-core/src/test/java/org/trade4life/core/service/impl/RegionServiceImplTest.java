package org.trade4life.core.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.trade4life.core.converter.RegionMapper;
import org.trade4life.core.model.RegionModel;
import org.trade4life.core.repository.RegionRepository;
import org.trade4life.core.web.dto.login.GetRegionsResponseDto;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.trade4life.core.fixture.RegionFixture.*;

@ExtendWith(MockitoExtension.class)
class RegionServiceImplTest {

    @Mock
    private RegionRepository repository;

    @Mock
    private RegionMapper regionMapper;

    @Spy
    @InjectMocks
    private RegionServiceImpl regionService;

    @Test
    void testContextInit() {
        assertThat(repository).isNotNull();
        assertThat(regionMapper).isNotNull();
        assertThat(regionService).isNotNull();
    }

    @Test
    public void shouldFindAllUsingRepositoryAndMapToDto() {
        RegionModel firstRegion = RegionModel.builder().id(1L).nameEn("Minsk").nameRu("Минск").currency("BYN").build();
        RegionModel secondRegion = RegionModel.builder().id(2L).nameEn("Brest").nameRu("Брест").currency("BYN").build();
        RegionModel thirdRegion = RegionModel.builder().id(3L).nameEn("Warsaw").nameRu("Варшава").currency("PLN").build();
        RegionModel forthRegion = RegionModel.builder().id(4L).nameEn("Moscow").nameRu("Москва").currency("RUB").build();
        List<RegionModel> regionList = List.of(firstRegion, secondRegion, thirdRegion, forthRegion);

        when(repository.findAll()).thenReturn(regionList);
        when(regionMapper.toDto(any())).thenReturn(regionDto());

        GetRegionsResponseDto result = regionService.findAll();

        verify(repository).findAll();
        verify(regionMapper, times(4)).toDto(any());
        assertThat(result.getRegions().size()).isEqualTo(4);
    }

    @Test
    public void shouldFindRegionByIdUsingRepository() {
        when(repository.findById(eq(REGION_ID))).thenReturn(Optional.of(regionModel()));

        regionService.findRegionById(REGION_ID);

        verify(repository).findById(eq(REGION_ID));
    }

}
