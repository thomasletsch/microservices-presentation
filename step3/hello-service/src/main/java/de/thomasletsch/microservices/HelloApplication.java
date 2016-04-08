package de.thomasletsch.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@SpringBootApplication
@Configuration
@EnableDiscoveryClient
@RestController
public class HelloApplication {

    private static String id = UUID.randomUUID().toString();

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/message", produces = MediaType.TEXT_PLAIN_VALUE)
    public String message() {
        ResponseEntity<String> counter = restTemplate.getForEntity("http://counter-service/counter", String.class);
        return "Hello Microservice with id " + id + ", call counter: " + counter.getBody();
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}
