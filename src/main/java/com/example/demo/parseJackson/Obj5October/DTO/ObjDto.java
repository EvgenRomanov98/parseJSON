package com.example.demo.parseJackson.Obj5October.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ObjDto {

    @JsonProperty("properties")
    private Properties properties;
    @JsonProperty("cities")
    private List<String> cities;
    @JsonProperty("role")
    private String role;
    @JsonProperty("phoneNumbers")
    private List<Integer> phonenumbers;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("permanent")
    private boolean permanent;
    @JsonProperty("name")
    private String name;
    @JsonProperty("empID")
    private int empid;
}
