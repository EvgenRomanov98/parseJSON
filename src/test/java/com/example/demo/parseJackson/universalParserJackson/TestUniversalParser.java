package com.example.demo.parseJackson.universalParserJackson;

import org.junit.Assert;
import org.junit.Test;

public class TestUniversalParser extends Assert {

    @Test
    public void chexkCorrectParse() throws Exception {
        String json = "{\n" +
                "  \"token\": \"token_boken\",\n" +
                "  \"request_id\": \"simple_request\",\n" +
                "  \"data\": {\n" +
                "  \t \"settings\": {\n" +
                "      \"desktop_id\": \"abc1234hj\",\n" +
                "      \"process_id\": \"java_proc\",\n" +
                "      \"class_id\": \"425\"\n" +
                "    }\n" +
                "    \n" +
                "  }\n" +
                "}";
        String output = "{\n" +
                "    \"request_id\": \"simple_request\",\n" +
                "    \"token\": \"token_boken\"\n" +
                "}";
//        assertEquals(output, new ServiceUniversalParser().writeInMapSimpleFieldsOfTheMainObject(new TreeMap<>(),new ObjectMapper(), ));

    }
}
