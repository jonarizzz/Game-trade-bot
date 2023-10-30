package org.trade4life.core.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.trade4life.core.model.RegionModel;
import org.trade4life.core.web.dto.login.RegionDto;

@Mapper(componentModel = "spring")
public interface RegionMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "currency", target = "currency")
    RegionDto toDto(RegionModel regionModel);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "currency", target = "currency")
    RegionModel toModel(RegionDto regionDto);
}
