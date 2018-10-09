package com.example.demo.parseJackson.Obj5October;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Object createJSON() throws JsonProcessingException {
        //не получилось
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode arrayNode = objectMapper.createArrayNode();
        ObjectNode objectNode = objectMapper.createObjectNode();

        arrayNode.add(1);
        arrayNode.add(2);
        arrayNode.add(3);
        objectNode.set("123", arrayNode);

        return objectNode;
    }
}
