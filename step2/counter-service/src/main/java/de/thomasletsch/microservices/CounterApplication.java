package de.thomasletsch.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CounterApplication {

    private static Integer COUNTER = 0;

    @RequestMapping(value = "/counter", produces = MediaType.TEXT_PLAIN_VALUE)
    public String message() {
        COUNTER++;
        return "" + COUNTER;
    }

    public static void main(String[] args) {
        SpringApplication.run(CounterApplication.class, args);
    }

}
