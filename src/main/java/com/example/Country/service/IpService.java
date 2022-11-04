/*package com.example.Country.service;


import com.example.Country.model.Ip;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class IpService {
@Autowired
    public final RestTemplate restTemplate;

    public Ip[] getByIp(String query) {
        Ip[] result = restTemplate.getForObject("http://ip-api.com/json", Ip[].class);
        for (Ip model : result) {
            restTemplate.getForObject("http://ip-api.com/json" + query,Ip[].class);
            System.out.println("Test");

        }

        return result;
    }




}


 */
