package org.trade4life.core.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.trade4life.core.service.RegionService;
import org.trade4life.core.web.dto.login.GetRegionsResponseDto;
import org.trade4life.core.web.dto.login.RegionDto;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RegionController.class, excludeAutoConfiguration = { SecurityAutoConfiguration.class })
@Import(TestConfig.class)
class RegionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RegionController regionController;

    @Autowired
    private RegionService regionService;

    @Test
    public void contextLoads() {
        assertThat(mockMvc).isNotNull();
        assertThat(regionController).isNotNull();
        assertThat(regionService).isNotNull();
    }

    @Test
    public void shouldGetListOfRegions() throws Exception {
        RegionDto firstRegion = RegionDto.builder().id(1L).name("Minsk").currency("BYN").build();
        RegionDto secondRegion = RegionDto.builder().id(2L).name("Brest").currency("BYN").build();
        RegionDto thirdRegion = RegionDto.builder().id(3L).name("Warsaw").currency("PLN").build();
        RegionDto forthRegion = RegionDto.builder().id(4L).name("Moscow").currency("RUB").build();
        GetRegionsResponseDto responseDto = GetRegionsResponseDto.builder()
            .regions(List.of(firstRegion, secondRegion, thirdRegion, forthRegion))
            .build();
        when(regionService.findAll()).thenReturn(responseDto);

        MockHttpServletRequestBuilder requestBuilder = get("/api/v1/region");

        mockMvc.perform(requestBuilder)
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.regions").isArray())
            .andExpect(jsonPath("$.regions[0].id").value("1"))
            .andExpect(jsonPath("$.regions[0].name").value("Minsk"))
            .andExpect(jsonPath("$.regions[0].currency").value("BYN"))
            .andExpect(jsonPath("$.regions[1].id").value("2"))
            .andExpect(jsonPath("$.regions[1].name").value("Brest"))
            .andExpect(jsonPath("$.regions[1].currency").value("BYN"))
            .andExpect(jsonPath("$.regions[2].id").value("3"))
            .andExpect(jsonPath("$.regions[2].name").value("Warsaw"))
            .andExpect(jsonPath("$.regions[2].currency").value("PLN"))
            .andExpect(jsonPath("$.regions[3].id").value("4"))
            .andExpect(jsonPath("$.regions[3].name").value("Moscow"))
            .andExpect(jsonPath("$.regions[3].currency").value("RUB"));
    }

    @Test
    public void shouldReturnEmptyListOfRegionsIfNoneFound() throws Exception {
        GetRegionsResponseDto responseDto = GetRegionsResponseDto.builder()
            .regions(new ArrayList<>())
            .build();
        when(regionService.findAll()).thenReturn(responseDto);

        MockHttpServletRequestBuilder requestBuilder = get("/api/v1/region");

        mockMvc.perform(requestBuilder)
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.regions").isArray())
            .andExpect(jsonPath("$.regions").isEmpty());
    }

}
