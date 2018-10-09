package com.example.demo.parseJackson.Obj5October.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Properties {
    @JsonProperty("salary")
    private String salary;
    @JsonProperty("age")
    private String age;
}
