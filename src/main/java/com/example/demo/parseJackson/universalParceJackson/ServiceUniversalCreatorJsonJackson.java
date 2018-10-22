package com.example.demo.parseJackson.universalParceJackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
@Slf4j
public class ServiceUniversalCreatorJsonJackson {
    //Map<String, String> generalMap1
    public ObjectNode createJson() {

        Map<String, String> subMap = new TreeMap<>();
        Map<String, String> generalMap = new TreeMap<>();
        generalMap.put("token1", "token1");
        generalMap.put("int1", "1231");
        generalMap.put("data2.int2", "1232");
        generalMap.put("data2.settings4.class_id4", "4254");
        generalMap.put("data5.settings6.settings10.desktop_id10", "abc1234hj10");
        generalMap.put("data5.settings6.settings10.process_i10", "java_proc10");
        generalMap.put("data2.array2", "[12,22]");

        System.out.println(generalMap);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode rootObject = mapper.createObjectNode();

        Iterator<Map.Entry<String, String>> iterator = generalMap.entrySet().iterator();

//        HashMap<ArrayList<String>, String> keysValues = new HashMap<>();
//        ArrayList<ObjectNode> objectNodes = new ArrayList<>();
        while (iterator.hasNext()) {

            Map.Entry<String, String> entry = iterator.next();

            String k = entry.getKey();
            String v = entry.getValue();

            if (!k.contains(".")) {
                rootObject.put(k, v);
                iterator.remove();
            }

            if (k.contains(".")) {
                iterator.remove();
                System.out.println("substring = " + k.substring(0, k.indexOf('.')));
                k = k.replace(k.substring(0, k.indexOf('.') + 1), "");

                System.out.println("last modifier key = " + k);
                subMap.put(k, v);
                //                keysValues.put(new ArrayList<>(Arrays.asList(k.split("\\."))), v);
//                System.out.println(keysValues);

            }
        }

        generalMap = new TreeMap<>(subMap);
        subMap.clear();

//        keysValues.forEach((k,v)->{
//            Iterator<String> iterator1 = k.iterator();
//            while (iterator1.hasNext()){
//                String obj = iterator1.next();
//                if(iterator1.hasNext()){
//                    objectNodes.add(mapper.createObjectNode().put(obj,v));
//                }
//            }
//        });

        System.out.println(generalMap);

        return rootObject;
    }
}
