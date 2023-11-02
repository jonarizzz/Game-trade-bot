package org.trade4life.core.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.trade4life.core.service.AuthService;
import org.trade4life.core.service.RegionService;
import org.trade4life.core.service.UserService;

@Configuration
public class TestConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RegionService regionService;

    @MockBean
    private UserService userService;

    @MockBean
    private AuthService authService;

}
