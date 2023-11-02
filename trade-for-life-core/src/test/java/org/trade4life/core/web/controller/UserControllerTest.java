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
import org.trade4life.core.service.UserService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.trade4life.core.fixture.UserFixture.setUserRegionRequestDto;

@WebMvcTest(controllers = UserController.class, excludeAutoConfiguration = { SecurityAutoConfiguration.class })
@Import(TestConfig.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void contextLoads() {
        assertThat(mockMvc).isNotNull();
        assertThat(userController).isNotNull();
        assertThat(userService).isNotNull();
    }

    @Test
    public void shouldSetUserRegion() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = put("/api/v1/user/setRegion")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(setUserRegionRequestDto()));

        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
        verify(userService).setUserRegion(any());
    }

}
