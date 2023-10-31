package org.trade4life.core.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.trade4life.core.exception.ResourceNotFoundException;
import org.trade4life.core.model.UserModel;
import org.trade4life.core.repository.UserRepository;
import org.trade4life.core.service.RegionService;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.trade4life.core.fixture.RegionFixture.REGION_ID;
import static org.trade4life.core.fixture.RegionFixture.regionModel;
import static org.trade4life.core.fixture.UserFixture.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private RegionService regionService;

    @Mock
    private UserRepository repository;

    @Spy
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testContextInit() {
        assertThat(userService).isNotNull();
        assertThat(repository).isNotNull();
        assertThat(userService).isNotNull();
    }

    @Test
    public void shouldGetUserFromControllerByTelegramId() {
        when(repository.findUserByTelegramId(eq(USER_TELEGRAM_ID))).thenReturn(Optional.of(userModel()));

        userService.getUserByTelegramId(USER_TELEGRAM_ID);

        verify(repository).findUserByTelegramId(eq(USER_TELEGRAM_ID));
    }

    @Test
    public void shouldSaveUserUsingRepository() {
        when(repository.save(any())).thenReturn(userModel());

        userService.saveUser(userModel());

        verify(repository).save(any());
    }

    @Test
    public void shouldSetUserRegionUsingRepository() {
        when(repository.findById(eq(USER_ID))).thenReturn(Optional.of(userModel()));
        when(regionService.findRegionById(eq(REGION_ID))).thenReturn(Optional.of(regionModel()));
        ArgumentCaptor<UserModel> userModelCaptor = ArgumentCaptor.forClass(UserModel.class);
        when(repository.save(any())).thenReturn(userModel());

        userService.setUserRegion(setUserRegionRequestDto());

        verify(repository).save(userModelCaptor.capture());
        UserModel capturedUserModel = userModelCaptor.getValue();

        assertThat(capturedUserModel.getRegion()).isNotNull();
        assertThat(capturedUserModel.getRegion().getId()).isEqualTo(REGION_ID);
    }

    @Test
    public void shouldThrowIfUserForSetRegionDoesNotExist() {
        when(repository.findById(eq(USER_ID))).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.setUserRegion(setUserRegionRequestDto()));
    }

    @Test
    public void shouldThrowIfRegionForSetRegionDoesNotExist() {
        when(repository.findById(eq(USER_ID))).thenReturn(Optional.of(userModel()));
        when(regionService.findRegionById(eq(REGION_ID))).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.setUserRegion(setUserRegionRequestDto()));
    }

}