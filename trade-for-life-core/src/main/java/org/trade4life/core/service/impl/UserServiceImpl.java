package org.trade4life.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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
        Optional<UserModel> userOptional = repository.findById(setUserRegionRequestDto.getUserId());
        if (userOptional.isEmpty()) {
            // TODO: 404 user not found
            throw new RuntimeException();
        }
        

        Optional<RegionModel> regionOptional = regionService.findRegionById(setUserRegionRequestDto.getRegionId());
        if (regionOptional.isEmpty()) {
            // TODO: 404 region not found
            throw new RuntimeException();
        }

        UserModel user = userOptional.get();
        RegionModel region = regionOptional.get();
        user.setRegion(region);
        repository.save(user);
    }
}
