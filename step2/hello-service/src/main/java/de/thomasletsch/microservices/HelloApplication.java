package de.thomasletsch.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class HelloApplication {

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/message", produces = MediaType.TEXT_PLAIN_VALUE)
    public String message() {
        ResponseEntity<String> counter = restTemplate.getForEntity("http://localhost:8081/counter", String.class);
        return "Hello Microservice, call counter: " + counter.getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}
