package com.example.demo.parseGSON.universalParserGson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/gson")
public class UniversalParserGson {

    @Autowired
    private ServiceUniversalParserGson serviceUniversalParserGson;

    @PostMapping("/universal")
    public Map<String, String> universalParse(@ModelAttribute String json){
        return serviceUniversalParserGson.parseJson(json);
    }
}
