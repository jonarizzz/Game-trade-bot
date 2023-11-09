package org.trade4life.bot.service;

import org.trade4life.bot.dto.SetUserRegionRequestDto;

public interface UserService {

    void setUserRegion(Long userTelegramId, Long regionId);

}
