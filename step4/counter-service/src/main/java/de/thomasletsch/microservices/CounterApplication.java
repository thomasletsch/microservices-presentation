package de.thomasletsch.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class CounterApplication {

    private static Integer COUNTER = 0;

    private static String id = UUID.randomUUID().toString();

    @RequestMapping(value = "/counter", produces = MediaType.TEXT_PLAIN_VALUE)
    public String message() {
        COUNTER++;
        System.out.println("Counter called. Instance: " + id);
        return "" + COUNTER + " Instance " + id;
    }

    public static void main(String[] args) {
        SpringApplication.run(CounterApplication.class, args);
    }

}
