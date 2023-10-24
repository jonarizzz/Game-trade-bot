package org.trade4life.core.web.dto0;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelloRequest {
    @NotNull
    private String name;
}
