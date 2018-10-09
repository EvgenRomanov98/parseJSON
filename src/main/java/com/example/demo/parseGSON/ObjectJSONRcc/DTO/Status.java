package com.example.demo.parseGSON.ObjectJSONRcc.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Status {
    @Expose
    @SerializedName("position")
    private String position;
}
