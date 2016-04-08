package de.thomasletsch.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@Configuration
@RestController
public class HelloApplication {

    private static String id = UUID.randomUUID().toString();

    @Autowired
    private RemoteCounterService counterService;

    @RequestMapping(value = "/message", produces = MediaType.TEXT_PLAIN_VALUE)
    public String message() {
        String counterMessage = counterService.getCounterMessage();
        return "Hello Microservice with id " + id + ", call counter: " + counterMessage;
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RemoteCounterService counterService() {
        return new RemoteCounterService();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}
