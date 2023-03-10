package com.example.disktraderstealerjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DiskTraderStealerJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiskTraderStealerJavaApplication.class, args);
    }

}
