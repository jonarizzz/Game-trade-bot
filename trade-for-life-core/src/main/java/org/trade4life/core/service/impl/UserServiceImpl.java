package org.trade4life.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.trade4life.core.exception.ResourceNotFoundException;
import org.trade4life.core.model.RegionModel;
import org.trade4life.core.model.UserModel;
import org.trade4life.core.repository.UserRepository;
import org.trade4life.core.service.RegionService;
import org.trade4life.core.service.UserService;
import org.trade4life.core.web.dto.login.SetUserRegionRequestDto;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RegionService regionService;
    private final UserRepository repository;

    @Override
    public Optional<UserModel> getUserByTelegramId(String telegramId) {
        return repository.findUserByTelegramId(telegramId);
    }

    @Override
    public UserModel saveUser(UserModel user) {
        return repository.save(user);
    }

    @Override
    public void setUserRegion(SetUserRegionRequestDto setUserRegionRequestDto) {
        log.info("Setting user region is requested with the following parameters:" + setUserRegionRequestDto);

        Long userId = setUserRegionRequestDto.getUserId();
        Long regionId = setUserRegionRequestDto.getRegionId();

        Optional<UserModel> userOptional = repository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException(userId.toString());
        }

        Optional<RegionModel> regionOptional = regionService.findRegionById(regionId);
        if (regionOptional.isEmpty()) {
            throw new ResourceNotFoundException(regionId.toString());
        }

        UserModel user = userOptional.get();
        RegionModel region = regionOptional.get();
        user.setRegion(region);
        repository.save(user);
    }
}
