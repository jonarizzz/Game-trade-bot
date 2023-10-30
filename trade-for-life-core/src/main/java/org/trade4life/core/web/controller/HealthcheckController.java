package org.trade4life.core.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "1. Healthcheck", description = "Healthcheck controller")
@Slf4j
@RestController
@RequestMapping("/healthcheck")
@RequiredArgsConstructor
public class HealthcheckController {

    @Operation(summary = "Simple GET endpoint to make sure the application is alive")
    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return String.format("Hello, %s!", name);
    }
}
