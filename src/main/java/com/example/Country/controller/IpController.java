package com.example.Country.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@AllArgsConstructor
public class IpController {
    private final String uri = "http://ip-api.com/json";
    private final RestTemplate restTemplate;

    @GetMapping("/me")
    public ResponseEntity<?> getMe() {
        try {
            String result = restTemplate.getForObject(uri, String.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Jbg", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{query}")
    public String getByIp(@PathVariable("query") String query) {
        try {
            return restTemplate.getForObject(uri + "/" + query, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return String.valueOf(new IllegalArgumentException("Error"));

        }
    }
}