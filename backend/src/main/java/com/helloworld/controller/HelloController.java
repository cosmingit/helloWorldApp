package com.helloworld.controller;

import com.helloworld.dto.HelloResponse;
import com.helloworld.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for hello world endpoints.
 * Handles all HTTP requests related to the hello functionality.
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private HelloService helloService;

    /**
     * GET endpoint that returns a hello message.
     *
     * @return ResponseEntity containing HelloResponse with status 200 OK
     */
    @GetMapping("/hello")
    public ResponseEntity<HelloResponse> getHello() {
        try {
            log.info("Processing GET request to /api/hello");
            
            HelloResponse response = helloService.getHelloMessage();
            
            log.info("Successfully processed request, returning: {}", response);
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            log.error("Error processing /api/hello request", e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

}