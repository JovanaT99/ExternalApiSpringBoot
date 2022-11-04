package com.example.Country.controller;


import com.example.Country.model.Ip;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@RestController
@AllArgsConstructor
public class IpController {
    private final String uri = "http://ip-api.com/json";
    private final RestTemplate restTemplate;
    // private final IpService ipService;

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

    //produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/{query}")
    public ResponseEntity<?>getByIp(@PathVariable("query") String query) {
       return new ResponseEntity<>("jbg",HttpStatus.OK);
    }


}
