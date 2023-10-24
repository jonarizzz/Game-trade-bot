package org.trade4life.core.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthcheck")
public class HealthcheckController {

    @Operation(
        summary = "Healthcheck",
        responses = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
        })
    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return String.format("Hello, %s!", name);
    }
}
