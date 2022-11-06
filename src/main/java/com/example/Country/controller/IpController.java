package com.example.Country.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @GetMapping(value="/ip/me",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMe() {
        try {
            String result = restTemplate.getForObject(uri, String.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/ip/{query}",produces= MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> getByIp(@PathVariable("query") String query) {
        try {
            return ResponseEntity.ok().body(restTemplate.getForObject(uri + "/" + query, String.class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}