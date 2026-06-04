package com.helloworld.service;

import com.helloworld.dto.HelloResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service class for hello world operations.
 * Handles business logic for the hello endpoint.
 */
@Slf4j
@Service
public class HelloService {

    /**
     * Generates a hello response with current timestamp.
     *
     * @return HelloResponse containing the message and timestamp
     */
    public HelloResponse getHelloMessage() {
        log.info("Generating hello message");
        
        HelloResponse response = new HelloResponse();
        response.setMessage("Hello World");
        response.setTimestamp(System.currentTimeMillis());
        
        log.debug("Hello response created: {}", response);
        return response;
    }

}