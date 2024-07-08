package com.azteklabs.doctorservice;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class BaseIT {

    private static final String DB_USERNAME = "testusername";
    private static final String DB_PASSWORD = "testpassword";

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("doctors")
            .withUsername(DB_USERNAME).withPassword(DB_PASSWORD)
            .withReuse(true);

    @BeforeAll
    static void beforeAll(){
        postgreSQLContainer.start();
    }

    @PostConstruct
    private void initializeDatabase() throws Exception{
        var database = DatabaseFactory.getInstance()
                .openDatabase(postgreSQLContainer.getJdbcUrl(), DB_USERNAME, DB_PASSWORD, null, null);
        Liquibase liquibase = new Liquibase("config/liquibase/master.xml", null, database);
        liquibase.update("");
    }

}
