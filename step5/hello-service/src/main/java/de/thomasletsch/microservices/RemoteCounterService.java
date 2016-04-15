package de.thomasletsch.microservices;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteCounterService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCounter")
    public String getCounterMessage() {
        ResponseEntity<String> counter = restTemplate.getForEntity("http://counter-service/counter", String.class);
        return counter.getBody();
    }

    private String getFallbackCounter() {
        return "-1 Instance <unavailable>";
    }

}
