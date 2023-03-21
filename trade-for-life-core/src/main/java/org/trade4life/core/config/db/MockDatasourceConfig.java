package org.trade4life.core.config.db;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MockDatasourceConfig {

    @Bean
    @Primary
    public DataSource mockDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/trade-bot")
                .username("postgres")
                .password("postgres")
                .driverClassName("org.postgresql.Driver")
                .build();
    }

}
