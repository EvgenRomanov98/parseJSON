package com.example.demo.parseGSON.ObjectJSONRcc.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ObjectJSON {

    @Expose
    @SerializedName("rcc")
    private List<Rcc> rcc;
}
