package org.trade4life.core.converter;

import org.junit.jupiter.api.Test;
import org.trade4life.core.model.RegionModel;
import org.trade4life.core.web.dto.login.RegionDto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.trade4life.core.fixture.RegionFixture.*;

class RegionMapperTest {

    @Test
    public void testNullMappers() {
        assertNull(RegionMapper.INSTANCE.toDto(null));
        assertNull(RegionMapper.INSTANCE.toModel(null));
    }

    @Test
    public void shouldConvertToDto() {
        RegionDto result = RegionMapper.INSTANCE.toDto(regionModel());

        assertThat(result.getId()).isEqualTo(REGION_ID);
        assertThat(result.getName()).isEqualTo(REGION_NAME);
        assertThat(result.getCurrency()).isEqualTo(REGION_CURRENCY);
    }

    @Test
    public void shouldConvertToModel() {
        RegionModel result = RegionMapper.INSTANCE.toModel(regionDto());

        assertThat(result.getId()).isEqualTo(REGION_ID);
        assertThat(result.getName()).isEqualTo(REGION_NAME);
        assertThat(result.getCurrency()).isEqualTo(REGION_CURRENCY);
    }

}
