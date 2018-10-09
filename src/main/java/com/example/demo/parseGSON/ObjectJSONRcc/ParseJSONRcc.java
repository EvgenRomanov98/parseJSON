package com.example.demo.parseGSON.ObjectJSONRcc;

import com.example.demo.parseGSON.ObjectJSONRcc.DTO.ObjectJSON;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringReader;

@RestController
@RequestMapping("/gson")
@Slf4j
public class ParseJSONRcc {

    @PostMapping("/parseRcc")
    public void parse(@RequestBody String json) {
//        method1(json);
        method2(json);
    }


    private void method1(String json) {
        log.info("--------------- method1");
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        ObjectJSON oj = gson.fromJson(json, ObjectJSON.class);
        System.out.println(oj.getRcc());
    }

    private void method2(String json) {
//        log.info("--------------- method2");
//        JsonReader jsonReader = new JsonReader(new StringReader(json));
//
//        try {
//            while (jsonReader.hasNext()) {
//                JsonToken nextToken = jsonReader.peek();
//                System.out.println(nextToken);
//
//
//                if (JsonToken.BEGIN_OBJECT.equals(nextToken)) {
//
//                    jsonReader.beginObject();
//
//                } else if (JsonToken.NAME.equals(nextToken)) {
//
//                    String name = jsonReader.nextName();
//                    System.out.println(name);
//
//                } else if (JsonToken.STRING.equals(nextToken)) {
//
//                    String value = jsonReader.nextString();
//                    System.out.println(value);
//
//                } else if (JsonToken.NUMBER.equals(nextToken)) {
//
//                    long value = jsonReader.nextLong();
//                    System.out.println(value);
//
//                } else if (JsonToken.BEGIN_ARRAY.equals(nextToken)) {
//
//                    jsonReader.beginArray();
//
//                } else if (JsonToken.BOOLEAN.equals(nextToken)) {
//                    System.out.println(jsonReader.nextBoolean());
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

//    private void method3(String json) {
//        log.info("--------- method3");
//        System.out.println(json);
//        JsonParser parser = new JsonParser();
//        JsonElement jsonTree = parser.parse(json);
//
//        JsonObject jo = jsonTree.getAsJsonObject();
//
//        System.out.println(jo.get("rcc"));
//
//        JsonArray jarr = jo.getAsJsonArray();
//
//        System.out.println(jarr.getAsJsonObject());
//

//        for (JsonElement jsonElement : jarr) {
//            JsonObject json = jsonElement.getAsJsonObject();
//            System.out.println(json);
//            JsonObject sofit = json.get("sofit").getAsJsonObject();
//            String place = sofit.get("Place").getAsString();
//            System.out.println(place);
//        }
//
//        JsonParser parser = new JsonParser();


//        if (jsonTree.isJsonObject()) {
//            JsonObject jsonObject = jsonTree.getAsJsonObject();
//            JsonElement f1 = jsonObject.get("f1");
//
//            System.out.println(f1);
//            System.out.println(f1.getAsString());
//
//            JsonElement f2 = jsonObject.get("f2");
//
//            System.out.println(f2);
//
//            if (f2.isJsonObject()) {
//                JsonObject f2Obj = f2.getAsJsonObject();
//
//                System.out.println(f2Obj);
//
//                JsonElement f3 = f2Obj.get("f3");
//
//                System.out.println(f3);
//            }
//
//        }
//}
}
