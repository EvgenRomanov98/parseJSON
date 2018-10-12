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

    private final String JSONExample = "\n" +
            "    \"empID\": \"100\",\n" +
            "    \"name\": \"David\",\n" +
            "    \"permanent\": \"false\",\n" +
            "    \"address\": {\n" +
            "        \"street\": \"BTM 1st Stage\",\n" +
            "        \"city\": \"Bangalore\",\n" +
            "        \"zipcode\": 560100,\n" +
            "        \"friend_addr\": {\n" +
            "            \"stree\": \"one\",\n" +
            "            \"codes\": [\n" +
            "                12345,\n" +
            "                2345\n" +
            "            ]\n" +
            "        }\n" +
            "    },\n" +
            "    \"phoneNumbers\": [\n" +
            "        123456,\n" +
            "        987654\n" +
            "    ],\n" +
            "    \"role\": \"Manager\",\n" +
            "    \"cities\": [\n" +
            "        \"Los Angeles\",\n" +
            "        \"New York\"\n" +
            "    ],\n" +
            "    \"properties\": {\n" +
            "        \"age\": \"28 years\",\n" +
            "        \"salary\": \"1000 Rs\"\n" +
            "    }\n" +
            "}";

    @PostMapping("/method1")
    public void method1(@RequestBody String json) throws Exception {
        log.info("--------------- method1");
        JsonReader jsonReader = new JsonReader(new StringReader(json));
        log.info(json);

        String friendAddrStreet = "";
        ArrayList<ArrayList<String>> allArrayJson = new ArrayList<>();

        try {
            int count = 0;
            while (jsonReader.hasNext()) {
                count++;//для проверки итерации
                JsonToken nextToken = jsonReader.peek();//показать следующий токен но не перейти на него
                log.info("start token {}", nextToken); // текущий токен
                log.info("start {}", count);
                if (JsonToken.BEGIN_OBJECT.equals(nextToken)) {// если следующий токен -- объект, то зайти в него. Метод ничего не аозвращает

                    jsonReader.beginObject();

                } else if (JsonToken.NAME.equals(nextToken)) {//если след токен является названием поля

                    String name = jsonReader.nextName();//то вернуть это поле и продолжить итерацию по токенам
                    log.info("name = {}", name);
                    if (name.equals("friend_addr")) {//если это поле friend_addr, то отсюда нужно взять сожержимое поля street
                        nextToken = jsonReader.peek();// след токен BEGIN_OBJECT
                        log.info("{}",nextToken);
                        jsonReader.beginObject(); // перейти в BEGIN_OBJECT
                        jsonReader.nextName(); // вернуть поле street
                        friendAddrStreet = jsonReader.nextString(); // вернуьт содержание поля street
                    }

                } else if (JsonToken.STRING.equals(nextToken)) { // если след токен стринговое значение поля

                    String value = jsonReader.nextString(); // вернуть это значение как сртоку
                    log.info("value = {}", value);

                } else if (JsonToken.NUMBER.equals(nextToken)) {//если след токен число

                    long value = jsonReader.nextLong();
                    log.info("number = {}", value);//вернуть число

                } else if (JsonToken.BEGIN_ARRAY.equals(nextToken)) { // если след токен начало массива
                    jsonReader.beginArray();//зайти в массив
                    nextToken = jsonReader.peek(); //значение следующего токена
                    ArrayList<String> arrays = new ArrayList<>();
                    allArrayJson.add(arrays);
                    STOP_FLAG:  //флаг для выхода из итерации по циклу
                    while (!JsonToken.END_ARRAY.equals(nextToken)) {//выполнять, пока не достигнет конца массива
                        arrays.add(jsonReader.nextString());//читаем содержимое как строку
                        nextToken = jsonReader.peek();//переходим на след токен
                        if (JsonToken.END_ARRAY.equals(nextToken)){//если след токен конец массива
                            jsonReader.endArray();//то выйти с массива
                            break STOP_FLAG;//вернуться к флагу
                        }
                    }
                    log.info("array {}", count);
                    nextToken = jsonReader.peek();//берем след токен
                    log.info("----peek {}", nextToken);
                    while (JsonToken.END_OBJECT.equals(nextToken)){ //выполнять, пока не выйдем со всех объектов(их там 2)
                        log.info("end object {}", nextToken);
                        jsonReader.endObject();//выйти с объекта
                        nextToken = jsonReader.peek();//взять след токен
                    }
                } else if (JsonToken.BOOLEAN.equals(nextToken)) {//если след токен булеан
                    log.info("{}", jsonReader.nextBoolean());
                }

                log.info("finish {}", count);
                log.info("finish {}", jsonReader.hasNext());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(friendAddrStreet);
        System.out.println(allArrayJson.toString());
    }
}
