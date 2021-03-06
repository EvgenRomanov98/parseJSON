package com.example.demo.parseJackson.universalParceJackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/jackson")
@Slf4j
public class UniversalParseJackson {

    @Autowired
    private ServiceUniversalParserJackson serviceUniversalParserJackson;

    @Autowired
    private ServiceUniversalCreatorJsonJackson serviceUniversalCreatorJsonJackson;

    private final String JSON = "{\n" +
            " \"token\": \"token_boken\",\n" +
            " \"request_id\": \"simple_request\",\n" +
            " \"data\": {\n" +
            "      \"settings\": {\n" +
            "     \"desktop_id\": \"abc1234hj\",\n" +
            "     \"process_id\": \"java_proc\",\n" +
            "     \"class_id\": \"425\"\n" +
            "   }\n" +
            " }\n" +
            "}";

    private Map<String, String> generalMap = new TreeMap<>();

    @PostMapping("/universal")
    public Map<String, String> universalParse(@RequestBody String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        LinkedHashMap mapJson = mapper.readValue(json, new TypeReference<LinkedHashMap>() {
        });

        serviceUniversalParserJackson.writeInMapSimpleFieldsOfTheMainObject(generalMap, mapper, mapJson);

//        innerObjectName.forEach(name -> {
//            String nameInnerObjectAccordingToConvention = name + ".";//добавляем точку, чтобы получилась запись соглассно конвенции. (пример:data.settings...)
//            serviceUniversalParserJackson.writeInMapSimpleFieldsOfTheMainObject(nameInnerObjectAccordingToConvention, generalMap, mapper, (LinkedHashMap) mapJson.get(name));
//        });

        return generalMap;
    }


    @GetMapping("/universal/creator")
    public ObjectNode createJson() {
        return serviceUniversalCreatorJsonJackson.createJson();
    }
}

