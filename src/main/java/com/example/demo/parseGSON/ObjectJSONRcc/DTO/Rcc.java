package com.example.demo.parseGSON.ObjectJSONRcc.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Rcc {
    @Expose
    @SerializedName("comment")
    private String comment;
    @Expose
    @SerializedName("type_operation")
    private String typeOperation;
    @Expose
    @SerializedName("token")
    private String token;
    @Expose
    @SerializedName("status")
    private Status status;
    @Expose
    @SerializedName("ovk")
    private List<String> ovk;
    @Expose
    @SerializedName("sofit")
    private Sofit sofit;
}
