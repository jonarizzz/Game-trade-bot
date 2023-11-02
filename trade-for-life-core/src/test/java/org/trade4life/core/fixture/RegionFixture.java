package org.trade4life.core.fixture;

import org.trade4life.core.model.RegionModel;
import org.trade4life.core.web.dto.login.RegionDto;

public class RegionFixture {

    public static final Long REGION_ID = 5L;
    public static final String REGION_NAME = "USSR";
    public static final String REGION_CURRENCY = "RUB";

    public static RegionModel regionModel() {
        return regionModel(REGION_ID, REGION_NAME, REGION_CURRENCY);
    }

    public static RegionModel regionModel(Long id, String name, String currency) {
        return RegionModel.builder()
            .id(id)
            .name(name)
            .currency(currency)
            .build();
    }

    public static RegionDto regionDto() {
        return RegionDto.builder()
            .id(REGION_ID)
            .name(REGION_NAME)
            .currency(REGION_CURRENCY)
            .build();
    }

}
