package com.example.demo.parseGSON.ObjectJSONRcc.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Sofit {
    @Expose
    @SerializedName("Status")
    private String status;
    @Expose
    @SerializedName("ru_Sname")
    private String ruSname;
    @Expose
    @SerializedName("ru_Lname")
    private String ruLname;
    @Expose
    @SerializedName("ru_Fname")
    private String ruFname;
    @Expose
    @SerializedName("ua_Sname")
    private String uaSname;
    @Expose
    @SerializedName("ua_Lname")
    private String uaLname;
    @Expose
    @SerializedName("ua_Fname")
    private String uaFname;
    @Expose
    @SerializedName("fio_en")
    private String fioEn;
    @Expose
    @SerializedName("birthday")
    private String birthday;
    @Expose
    @SerializedName("Sex")
    private String sex;
    @Expose
    @SerializedName("Lang")
    private String lang;
    @Expose
    @SerializedName("Country2")
    private String country2;
    @Expose
    @SerializedName("Ser")
    private String ser;
    @Expose
    @SerializedName("Num")
    private String num;
    @Expose
    @SerializedName("Type")
    private String type;
    @Expose
    @SerializedName("date")
    private String date;
    @Expose
    @SerializedName("Country")
    private String country;
    @Expose
    @SerializedName("Place")
    private String place;
}
