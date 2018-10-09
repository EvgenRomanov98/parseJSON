package com.example.demo.parseJackson.Obj5October;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/jackson")
@Slf4j
public class ParseJSON5Oct {

    @PostMapping("/method1")
    public void method1(@RequestBody String json) {
        String street; // для проверки название поля
        String valueStreet = ""; // название улицы, которую нужно вывести
        ArrayList<ArrayList<String>> allArrayJson = new ArrayList<>(); // все массивы в JSON
        try {
            log.info("------------ method1 {}", json);
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser parser = jsonFactory.createParser(json);
            while (!parser.isClosed()) {//пока не конец

                JsonToken jsonToken1 = parser.nextToken(); // переходим на след токен. здесь токен, это каждое поле.
                JsonToken jsonToken2 = null;

                if (JsonToken.FIELD_NAME.equals(jsonToken1)) {
                    String fieldName = parser.getCurrentName(); // получить название поля

                    // System.out.println(fieldName);
                    jsonToken2 = parser.nextToken(); // переходим на содержание этого поля

                    if (fieldName.equals("friend_addr")) { //если название поля такое, то след значение пустота.(по условию структуры нашего JSON)
                        parser.nextToken();// с пустоты переходим на след поле
                        street = parser.getCurrentName();//поле называется вот так.
                        parser.nextToken();//переходим на значяение этого поля
                        valueStreet = parser.getValueAsString();//получаем значение этого поля
                        log.info("------ check street");
//                        System.out.println(fieldName);
//                        System.out.println(street);
//                        System.out.println(valueStreet);
                    }
                }

                log.info("------- json token1 + {} ------- json token2 + {}", jsonToken1, jsonToken2);


                if (JsonToken.START_ARRAY.equals(jsonToken2)) {//если токен находиться на начале массива
                    ArrayList<String> field = new ArrayList<>();
                    while (!JsonToken.END_ARRAY.equals(parser.nextToken())) {//по заходим в массив и работаем с ним до окончания массива
                        log.info("------ check array");
                        field.add(parser.getValueAsString());//добавляем все записи в колекцию
                    }
                    allArrayJson.add(field);//добавляем коллекцию с записями в коллекцию
                }
            }

            System.out.println("friend_addr.street = " + valueStreet); // результат
            System.out.println("All Array in JSON = " + allArrayJson.toString()); //результат
        } catch (Exception e) {
            e.printStackTrace();
        }

        //возможный похожий вариант через JsonNode: просто как пример для себя, что бы не забыть.
        /*
        JsonNode node = objectMapper.readValue(strJson, JsonNode.class);
        System.out.println(node.findValues("Sex").get(0));
        System.out.println(node.findValues("Type").get(0));
        System.out.println(node.findValues("fio_en").get(0));
        System.out.println(node.findValues("token").get(0));
        */
    }

}
