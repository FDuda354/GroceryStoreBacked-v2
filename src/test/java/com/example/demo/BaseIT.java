package com.example.demo;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@WithMockUser
@ActiveProfiles("test")
@Testcontainers
public class BaseIT {

    @Container
    private static PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:14.1")
            .withDatabaseName("test")
            .withUsername("filip")
            .withPassword("filip1234");

    @DynamicPropertySource
    public static void containerConfig(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    }
//    @DynamicPropertySource
//    public static void setProperties() {
//        System.setProperty("spring.datasource.url", postgreSQLContainer.getJdbcUrl());
//        System.setProperty("spring.datasource.username", postgreSQLContainer.getUsername());
//        System.setProperty("spring.datasource.password", postgreSQLContainer.getPassword());
//    }
}
