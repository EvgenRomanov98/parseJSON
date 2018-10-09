package com.example.demo.parseGSON.ObjectJSONRcc;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Slf4j
@RequestMapping("/gson")
public class CreateJSONRcc {

    @GetMapping("/getRcc")
    public Object createJson() {

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        //1.Структуры данных
        Map<String, String> paramMapSofit = new HashMap<>();
        paramMapSofit.put("Place", "Соборным МВД УВД");
        paramMapSofit.put("date", "2009-08-02");
        paramMapSofit.put("fio_en", "dianorev");

        List<String> ovkList = new ArrayList<>(Arrays.asList("id", "title"));

        Map<String, String> objectMapStatus = new HashMap<>();
        objectMapStatus.put("position", "first");


        //  2. Генерируем джейсон
        JsonObject parentObject = new JsonObject();
        JsonArray jsonArrayRcc = new JsonArray();
        JsonObject dataObject = new JsonObject();
        JsonObject jsonObjectSofit = new JsonObject();
        JsonObject jsonObjectStatus = new JsonObject();


        JsonElement stringListJsonArrayOvk = gson.toJsonTree(ovkList, new TypeToken<List<String>>() {
        }.getType());

        for (Map.Entry<String, String> entry : paramMapSofit.entrySet()) {
            jsonObjectSofit.addProperty(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : objectMapStatus.entrySet()) {
            jsonObjectStatus.addProperty(entry.getKey(), entry.getValue());
        }

//        String JSONObject = gson.toJson(jsonObjectStatus);
        // statusObject.addProperty("status", JSONObject);
        dataObject.add("status", jsonObjectStatus);
        dataObject.add("sofit", jsonObjectSofit);
        dataObject.add("ovk", stringListJsonArrayOvk);
        dataObject.addProperty("type_operation", "human_add");
        dataObject.addProperty("comment", "add human person from space");

        jsonArrayRcc.add(dataObject);
        jsonArrayRcc.add(dataObject);
        jsonArrayRcc.add(dataObject);

        parentObject.add("rcc", jsonArrayRcc);

        return parentObject;
    }
}
