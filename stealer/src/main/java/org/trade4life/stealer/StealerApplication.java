package org.trade4life.stealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class StealerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StealerApplication.class, args);
    }

}
