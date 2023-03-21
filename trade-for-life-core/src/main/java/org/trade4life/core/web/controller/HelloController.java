package org.trade4life.core.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.trade4life.core.web.dto.HelloRequest;
import org.trade4life.core.web.dto.HelloResponse;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HelloResponse sayHello(@RequestBody final HelloRequest request) {
        return HelloResponse.builder()
            .message(String.format("Hello %s!", request.getName()))
            .build();
    }
}
