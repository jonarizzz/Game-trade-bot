package org.trade4life.core.web.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.trade4life.core.model.UserModel;
import org.trade4life.core.service.UserService;
import org.trade4life.core.service.user.UserResponse;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/telegram")
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Api(value = "core-users", tags = "core-users")
@Validated
public class UsersController {

    private final UserService userService;

    @GetMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> getUsers(
        @RequestParam(name = "page") @NotNull @Positive Integer page,
        @RequestParam(name = "size") @NotNull @Positive Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        UserResponse users = userService.findUsers(pageable);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "users/{telegramId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> getUserByTelegramId(
        @PathVariable(name = "telegramId") @NotBlank String telegramId) {
        UserModel telegramUser = userService.findUserByTelegramId(telegramId);
        return new ResponseEntity<>(telegramUser, HttpStatus.OK);
    }


    @GetMapping(value = "/users/{nickname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> getUserByNickname(@PathVariable(name = "nickname") @NotNull @Positive String nickname) {
        UserModel user = userService.findUserByNickname(nickname);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> registerNewUser(@RequestBody @NotNull UserModel user) {
        UserModel newUser = userService.addNewUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PutMapping(value = "users/{telegramId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> updateUser(
        @RequestBody @NotNull UserModel user,
        @PathVariable(name = "telegramId") @NotBlank String telegramId) {
        user.setTelegramId(telegramId);
        UserModel updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.NO_CONTENT);
    }
}
