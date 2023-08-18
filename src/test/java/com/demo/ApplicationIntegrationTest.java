package com.demo;

import com.demo.customer.Customer;
import com.demo.customer.CustomerRepository;
import com.demo.customer.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.UUID;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationIntegrationTest {

    @Container
    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:latest"));

    @Autowired
    CustomerRepository repository;

    @Autowired
    CustomerService service;

    @AfterEach
    void cleanUp() {
        repository.deleteAll();
//        mongoDBContainer.
    }

    @BeforeEach
    void before() {
//        mongoDBContainer.start();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        String id = UUID.randomUUID().toString();
        String name = "Test";
        String document = "123";
        Customer customer = repository.save(new Customer(id, name, document));

        Assertions.assertFalse(repository.findAll().isEmpty());
        Assertions.assertEquals(id, customer.id);
        Assertions.assertEquals(name, customer.name);
        Assertions.assertEquals(document, customer.document);
    }

    @Test
    void testCreate() {
        String name = "Test";
        String document = "123";
        Customer customer = service.create(name, document);
        Assertions.assertNotNull(customer);
        Assertions.assertNotNull(customer.id);
        Assertions.assertEquals(name, customer.name);
        Assertions.assertEquals(document, customer.document);
    }

}

