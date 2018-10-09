package com.example.demo.parseJackson.Obj5October.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {
    @JsonProperty("friend_addr")
    private FriendAddr friendAddr;
    @JsonProperty("zipcode")
    private int zipcode;
    @JsonProperty("city")
    private String city;
    @JsonProperty("street")
    private String street;
}
