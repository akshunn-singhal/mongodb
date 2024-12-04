package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;

public class SimpleContainerTest {

    @Test
    void testcontainer() {
        System.setProperty("docker.host", "unix:///var/run/docker.sock");
        try(GenericContainer<?> container = new GenericContainer<>("alpine:latest").withCommand("sleep", "10")){
            container.start();
            System.out.println("container is running:"+ container.isRunning());
        }
    }
}
