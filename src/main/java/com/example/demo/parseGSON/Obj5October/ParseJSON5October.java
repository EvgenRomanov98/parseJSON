package com.example.demo.parseGSON.Obj5October;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

@RestController
@Slf4j
@RequestMapping("/gson")
public class ParseJSON5October {

    @PostMapping("/method1")
    public void method1(@RequestBody String json) throws Exception {
        log.info("--------------- method1");
        JsonReader jsonReader = new JsonReader(new StringReader(json));
        log.info(json);

        String friendAddrStreet = "";
        ArrayList<ArrayList<String>> allArrayJson = new ArrayList<>();

        try {
            while (jsonReader.hasNext()) {
                JsonToken nextToken = jsonReader.peek();
                System.out.println(nextToken);

                if (JsonToken.BEGIN_OBJECT.equals(nextToken)) {

                    jsonReader.beginObject();

                } else if (JsonToken.NAME.equals(nextToken)) {

                    String name = jsonReader.nextName();
                    log.info("------------- name = {}", name);
                    if (name.equals("friend_addr")) {
                        nextToken = jsonReader.peek();
                        System.out.println(nextToken);
                        jsonReader.beginObject();
                        jsonReader.nextName();
                        friendAddrStreet = jsonReader.nextString();
                    }

                } else if (JsonToken.STRING.equals(nextToken)) {

                    String value = jsonReader.nextString();
                    log.info("------------- value = {}", value);

                } else if (JsonToken.NUMBER.equals(nextToken)) {

                    long value = jsonReader.nextLong();
                    log.info("------------- number = {}", value);

                } else if (JsonToken.BEGIN_ARRAY.equals(nextToken)) {
                    jsonReader.beginArray();
                    nextToken = jsonReader.peek();
                    ArrayList<String> arrays = new ArrayList<>();
                    while (!JsonToken.END_ARRAY.equals(nextToken)) {
                        arrays.add(jsonReader.nextString());
                        nextToken = jsonReader.peek();
                    }
                    allArrayJson.add(arrays);
                    System.out.println("-----------" + nextToken);
                    jsonReader.endArray();

                } else if (JsonToken.BOOLEAN.equals(nextToken)) {
                    System.out.println(jsonReader.nextBoolean());
                } else if (JsonToken.END_OBJECT.equals(nextToken)){
                    System.out.println(nextToken);
                    jsonReader.endObject();
                }else if (JsonToken.END_ARRAY.equals(nextToken)){
                    System.out.println(nextToken);
                    jsonReader.endArray();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(friendAddrStreet);
        System.out.println(allArrayJson.toString());
    }
}
