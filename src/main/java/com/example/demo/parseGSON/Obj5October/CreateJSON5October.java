package com.example.demo.parseGSON.Obj5October;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gson")
@Slf4j
@RestController
public class CreateJSON5October {

    private final String JSON = "{\n" +
            "  \"empID\": 100,\n" +
            "  \"name\": \"David\",\n" +
            "  \"permanent\": false,\n" +
            "  \"address\": {\n" +
            "    \"street\": \"BTM 1st Stage\",\n" +
            "    \"city\": \"Bangalore\",\n" +
            "    \"zipcode\": 560100,\n" +
            "    \"friend_addr\": {\n" +
            "      \"street\": \"one\",\n" +
            "      \"codes\": [\n" +
            "        12345,\n" +
            "        2345\n" +
            "      ]\n" +
            "    }\n" +
            "  },\n" +
            "  \"phoneNumbers\": [\n" +
            "    123456,\n" +
            "    987654\n" +
            "  ],\n" +
            "  \"role\": \"Manager\",\n" +
            "  \"cities\": [\n" +
            "    \"Los Angeles\",\n" +
            "    \"New York\"\n" +
            "  ],\n" +
            "  \"properties\": {\n" +
            "    \"age\": \"28 years\",\n" +
            "    \"salary\": \"1000 Rs\"\n" +
            "  }\n" +
            "}";

    @GetMapping("/5oct")
    public Object createJSON() {
        //создаем JSON объекты и JSON массивы и просто влаживаем их друг в друга соглассно примеру JSONa
        //1 объект с вложеным адресом и френд адресом
        JsonObject generalObject = new JsonObject();

        generalObject.addProperty("empID", "100");
        generalObject.addProperty("name", "David");
        generalObject.addProperty("permanent", "false");

        JsonObject addressObject = new JsonObject();

        addressObject.addProperty("street", "BTM 1st Stage");
        addressObject.addProperty("city", "Bangalore");
        addressObject.addProperty("zipcode", 560100);

        JsonObject friendAddressObject = new JsonObject();

        friendAddressObject.addProperty("stree", "one");

        JsonArray jsonArrayCodes = new JsonArray();
        jsonArrayCodes.add(12345);
        jsonArrayCodes.add(2345);

        friendAddressObject.add("codes", jsonArrayCodes);
        addressObject.add("friend_addr", friendAddressObject);

        generalObject.add("address", addressObject);
        // начало 2 массива

        JsonArray phoneNumbers = new JsonArray();
        phoneNumbers.add(123456);
        phoneNumbers.add(987654);

        generalObject.add("phoneNumbers", phoneNumbers);

        generalObject.addProperty("role", "Manager");

        JsonArray cities = new JsonArray();
        cities.add("Los Angeles");
        cities.add("New York");

        generalObject.add("cities", cities);

        JsonObject properties = new JsonObject();
        properties.addProperty("age", "28 years");
        properties.addProperty("salary", "1000 Rs");

        generalObject.add("properties", properties);

        return generalObject;
    }
}
