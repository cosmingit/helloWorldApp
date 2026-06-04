package com.helloworld.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Hello response.
 * Represents the JSON response returned by the /api/hello endpoint.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloResponse {
    
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("timestamp")
    private Long timestamp;

}