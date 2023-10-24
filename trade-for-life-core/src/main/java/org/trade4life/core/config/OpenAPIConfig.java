package org.trade4life.core.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI openAPI(final Info apiInfo) {
        return new OpenAPI()
            .info(apiInfo);
    }

    @Bean
    public Info apiInfo(final Contact contact) {
        return new Info()
            .title("game-trade-bot API")
            .contact(contact)
            .description("Game trade bot API");
    }

    @Bean
    public Contact contact() {
        return new Contact()
            .name("Yauheni Azaronak")
            .url("https://t.me/Azaratos")
            .email("Azaronak.Eugene@gmail.com");
    }
}
