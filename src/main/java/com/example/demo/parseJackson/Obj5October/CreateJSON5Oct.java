package com.example.demo.parseJackson.Obj5October;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@RestController
@Slf4j
@RequestMapping("/jackson")
public class CreateJSON5Oct {

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
    public Object createJSON() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode generalNode = mapper.createObjectNode(); // создание главного объекта
        generalNode.put("empId", 100); // помещаем поля в него
        generalNode.put("name", "David");
        generalNode.put("permanent", false);

        ObjectNode addressNode = mapper.createObjectNode(); // создаем объект адресс
        addressNode.put("street", "BTM 1st Stage");
        addressNode.put("city","Bangalore");
        addressNode.put("zipcode", 560100);

        ObjectNode friend_addressNode = mapper.createObjectNode(); // создаем объект friend_address
        friend_addressNode.put("street","one");

        ArrayNode codes = mapper.createArrayNode(); // создаем массив codes
        codes.add(12345);
        codes.add(2345);

        friend_addressNode.set("codes", codes); // добавляем в friend_address массив codes
        addressNode.set("friend_addr", friend_addressNode); // добавляем в addressNode friend_address
        generalNode.set("address",addressNode); //добавляем в основной объект наш объект адресс

        //далее по аналогии
        ArrayNode phoneNumbers = mapper.createArrayNode();
        phoneNumbers.add(123456);
        phoneNumbers.add(987654);

        generalNode.set("phoneNumbers",phoneNumbers);

        generalNode.put("role", "Manager");

        ArrayNode cities = mapper.createArrayNode();
        cities.add("Los Angeles");
        cities.add("New York");

        generalNode.set("cities",cities);

        ObjectNode properties = mapper.createObjectNode();
        properties.put("age", "28 years");
        properties.put("salary", "1000 Rs");

        generalNode.set("properties",properties);

        return generalNode;
    }
}
