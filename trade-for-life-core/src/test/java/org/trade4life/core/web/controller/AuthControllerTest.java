package org.trade4life.core.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.trade4life.core.exception.InternalServerException;
import org.trade4life.core.service.AuthService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.trade4life.core.fixture.UserFixture.*;

@WebMvcTest(controllers = AuthController.class, excludeAutoConfiguration = { SecurityAutoConfiguration.class })
@Import(TestConfig.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthController authController;

    @Autowired
    private AuthService authService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void contextLoads() {
        assertThat(mockMvc).isNotNull();
        assertThat(authController).isNotNull();
        assertThat(authService).isNotNull();
    }

    @Test
    public void shouldPerformLogin() throws Exception {
        when(authService.login(any())).thenReturn(userLoginResponseDto());

        MockHttpServletRequestBuilder requestBuilder = post("/api/v1/auth/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(userLoginRequestDto()));

        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.userId").value(USER_ID.toString()))
            .andExpect(jsonPath("$.isNew").value("false"));

        verify(authService).login(any());
    }

    @Test
    public void shouldThrowOnFailedLoginAttempt() throws Exception {
        when(authService.login(any())).thenThrow(new InternalServerException());

        MockHttpServletRequestBuilder requestBuilder = post("/api/v1/auth/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(userLoginRequestDto()));

        mockMvc.perform(requestBuilder).andExpect(status().is5xxServerError());
    }

}
