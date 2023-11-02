package org.trade4life.core.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.trade4life.core.model.UserModel;
import org.trade4life.core.web.dto.login.UserLoginRequestDto;
import org.trade4life.core.web.dto.login.UserLoginResponseDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "telegramId", target = "telegramId")
    @Mapping(source = "nickname", target = "nickname")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "phone", target = "phone")
    UserModel toModel(UserLoginRequestDto dto);

    @Mapping(source = "id", target = "userId")
    @Mapping(target = "isNew", constant = "false")
    UserLoginResponseDto toDto(UserModel model);

}
