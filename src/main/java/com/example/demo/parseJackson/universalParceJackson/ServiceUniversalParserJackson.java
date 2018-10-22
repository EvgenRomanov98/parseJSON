package com.example.demo.parseJackson.universalParceJackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class ServiceUniversalParserJackson {

//    String exampleJson = "{\n" +
//            "  \"token1\":\"token1\",\n" +
//            "  \"int1\": 1231,\n" +
//            "  \"inqt1\": 1233.1231,\n" +
//            "  \"array1\": [\n" +
//            "    \"sdff1\",\n" +
//            "    21\n" +
//            "  ],\n" +
//            "  \"request_id1\": \"simple_request1\",\n" +
//            "  \"data2\": {\n" +
//            "    \"token2\": \"token_boken2\",\n" +
//            "    \"int2\": 1232,\n" +
//            "    \"array2\": [\n" +
//            "      12,\n" +
//            "      22\n" +
//            "    ],\n" +
//            "    \"settings3\": {\n" +
//            "      \"token3\": \"token_boken3\",\n" +
//            "      \"int3\": 1233,\n" +
//            "      \"array3\": [\n" +
//            "      23,\n" +
//            "      33\n" +
//            "      ],\n" +
//            "      \"desktop_id3\": \"abc1234hj3\",\n" +
//            "      \"process_id3\": \"java_proc3\",\n" +
//            "      \"class_id3\": \"4253\"\n" +
//            "    },\n" +
//            "    \"settings4\": {\n" +
//            "      \"desktop_id4\": \"abc1234hj4\",\n" +
//            "      \"process_id4\": \"java_proc4\",\n" +
//            "      \"class_id4\": \"4254\"\n" +
//            "    }\n" +
//            "  },\n" +
//            "  \"data5\": {\n" +
//            "    \"settings6\": {\n" +
//            "      \"desktop_id6\": \"abc1234hj6\",\n" +
//            "      \"process_id6\": \"java_proc6\",\n" +
//            "      \"class_id6\": \"4256\",\n" +
//            "      \"settings7\": {\n" +
//            "      \t\"settings8\": {\n" +
//            "        \"desktop_id9\": \"abc1234hj9\",\n" +
//            "        \"process_id9\": \"java_proc9\",\n" +
//            "        \"class_id9\": \"4259\"\n" +
//            "      },\n" +
//            "        \"desktop_id7\": \"abc1234hj7\",\n" +
//            "        \"process_id7\": \"java_proc7\",\n" +
//            "        \"class_id7\": \"4257\"\n" +
//            "      },\n" +
//            "      \"settings10\": {\n" +
//            "        \"desktop_id10\": \"abc1234hj10\",\n" +
//            "        \"process_i10\": \"java_proc10\",\n" +
//            "        \"class_id10\": \"42510\"\n" +
//            "      }\n" +
//            "    }\n" +
//            "  }\n" +
//            "}";

    public void writeInMapSimpleFieldsOfTheMainObject(Map<String, String> generalMap, ObjectMapper mapper, LinkedHashMap mapJson) {
//        ArrayList<String> arrayOfInnerObjectNames = new ArrayList<>();
//        Iterator<Map.Entry<String, String>> iterator = mapJson.entrySet().iterator();//берем итератор с коллекции
//        while (iterator.hasNext()) {
//            try {
//                Map.Entry entry = iterator.next();//получаем ентри коллекции и берем из нее ключ и значение
//                String key = entry.getKey().toString();
//                String value = entry.getValue().toString();
//                JsonNode node = mapper.readTree(mapper.writeValueAsString(entry.getValue())); //записать value коллекции как строку и представить ее в виде JsonNode
//
//                log.info("key = {} , value = {}, entry.getValue = {} , node = {}, ----- {}", key, value, entry.getValue(), node, mapper.writeValueAsString(entry.getValue())); //проверка
////                System.out.println("asText() " + node.asText());
////                System.out.println("isInt() " + node.isInt());
////                System.out.println("isFloat() " + node.isFloat());
////                System.out.println("isDouble() " + node.isDouble());
////                System.out.println("isTextual() " + node.isTextual());
////                System.out.println("isObject() " + node.isObject());
////                System.out.println("isArray() " + node.isArray());
//                if (node.isTextual() || node.isDouble() || node.isBoolean() || node.isInt() || node.isFloat()) {//если value таких типов то:
//                    generalMap.put(key, value); //запишем их как строковые значения
//                    iterator.remove();//удалим записаный эелемент из mapJson
//                }else if(node.isArray()){//если в главном объекте есть массив, то записать его так
//                    generalMap.put(key, mapper.writeValueAsString(node));//записать в результирующую коллекцию
//                    iterator.remove();//удалить массив из разбираемой коллекции
//                }else if (node.isObject()){//если это объект то записать его название и вернуть из метода
//                    arrayOfInnerObjectNames.add(key);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        String nameWithoutInnerObjectInJson = "";
        writeInMapSimpleFieldsOfTheMainObject(nameWithoutInnerObjectInJson, generalMap, mapper, mapJson);
    }


    public void writeInMapSimpleFieldsOfTheMainObject(String name, Map<String, String> generalMap, ObjectMapper mapper, LinkedHashMap mapJson) {
        ArrayList<String> arrayOfInnerObjectNames = new ArrayList<>();
        Iterator<Map.Entry<String, String>> iterator = mapJson.entrySet().iterator();//берем итератор с коллекции
        while (iterator.hasNext()) {
            try {
                Map.Entry entry = iterator.next();//получаем ентри коллекции и берем из нее ключ и значение
                String key = name + entry.getKey().toString(); //делаем name + entry.getKey().toString() чтобы добиться соответствию конвенции (data.settings...)
                String value = entry.getValue().toString().trim();
                JsonNode node = mapper.readTree(mapper.writeValueAsString(entry.getValue())); //записать value коллекции как строку и представить ее в виде JsonNode

//                log.info("key = {} , value = {}, entry.getValue = {} , node = {}, ----- {}", key, value, entry.getValue(), node, mapper.writeValueAsString(entry.getValue())); //проверка

                if (!checkFieldEmpty(generalMap, value, key)) {// проверка на то, пришло ли к нам пустое значение
                    if (node.isTextual() || node.isDouble() || node.isBoolean() || node.isInt() || node.isFloat()) {//если value таких типов то:
                        generalMap.put(key, value); //запишем value в виде Json если поле не пустое. иначе удалим поле из результирующей generalMap
                        iterator.remove();//удалим записаный эелемент из mapJson
                    } else if (node.isArray()) {//если в главном объекте есть массив, то записать его так
                        generalMap.put(key, mapper.writeValueAsString(node));//записать в результирующую коллекцию если поле не пустое
                        iterator.remove();//удалить массив из разбираемой коллекции
                    } else if (node.isObject()) {//если это объект то записать его название и вернуть из метода
                        arrayOfInnerObjectNames.add(key);//записываем в лист названий
                        LinkedHashMap endParseObject = mapper.readValue(node.toString(), new TypeReference<LinkedHashMap>() { // и потом читаем Value снова как LinkedHashMap
                        });
                        writeInMapSimpleFieldsOfTheMainObject(key + ".", generalMap, mapper, endParseObject);//запускаем рекурсию и с помощью этого добиваемся практически любой вложености.
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean checkFieldEmpty(Map<String, String> generalMap, String value, String key) {
        if (value.equals("") || value.equals("[]")) {// если это простой объект или массив, то мы знаем его полный ключь в generalMap(например: data.settings.array)
            log.info("key = {} , remove = {}", key, generalMap.remove(key)); // и мы можем четко щапись по ключу
            return true;
        } else if (value.equals("{}")) {
            // если же к нам пришел пустой объект, то ключ бедет выглядеть так: data.settings, а дальше в нашем generalMap могут быль любые записи в этом объекте.
            //соответственно нам нужно удлить абсолютно все записи объекта data.settings... Поэтому необходимо перебрать коллекцию и удалить совпадения
            Iterator<String> iteratorGeneral = generalMap.keySet().iterator();
            while (iteratorGeneral.hasNext()) {
                String generalKey = iteratorGeneral.next();
                if (generalKey.contains(key)) {
                    System.out.println("--------++++++" + generalKey + " , and key =  " + key);
                    iteratorGeneral.remove();
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
