package com.example.Country.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Ip {

    //private String status;
    private String country;
    private String countryCode;
    private String region;
    private String region_code;
    private String city;
    private String zip;
    private String lat;
    private String lon;
    private String timezone;
    private String isp;
   // private String org;
   // private String as;
    //private String query;

}


