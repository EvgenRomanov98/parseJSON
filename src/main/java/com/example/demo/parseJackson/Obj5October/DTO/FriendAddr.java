package com.example.demo.parseJackson.Obj5October.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class FriendAddr {
    @JsonProperty("codes")
    private List<Integer> codes;
    @JsonProperty("street")
    private String street;
}
