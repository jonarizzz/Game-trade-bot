package org.trade4life.core.fixture;

import org.trade4life.core.model.RegionModel;
import org.trade4life.core.web.dto.login.RegionDto;

public class RegionFixture {

    public static final Long REGION_ID = 5L;
    public static final String REGION_NAME_EN = "USSR";
    public static final String REGION_NAME_RU = "СССР";
    public static final String REGION_CURRENCY = "RUB";

    public static RegionModel regionModel() {
        return regionModel(REGION_ID, REGION_NAME_EN, REGION_NAME_RU, REGION_CURRENCY);
    }

    public static RegionModel regionModel(Long id, String nameEn, String nameRu, String currency) {
        return RegionModel.builder()
            .id(id)
            .nameEn(nameEn)
            .nameRu(nameRu)
            .currency(currency)
            .build();
    }

    public static RegionDto regionDto() {
        return RegionDto.builder()
            .id(REGION_ID)
            .nameEn(REGION_NAME_EN)
            .nameRu(REGION_NAME_RU)
            .currency(REGION_CURRENCY)
            .build();
    }

}
