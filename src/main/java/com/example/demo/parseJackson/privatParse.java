package com.example.demo.parseJackson;

public class privatParse {

    //        RabbitStat rabbitStatDTO = new RabbitStat();
//        try {
//            JsonFactory jsonFactory = new JsonFactory();
//            JsonParser parser = jsonFactory.createParser(rabbitMassageJSON);
//            JsonToken jsonToken = parser.nextToken();
//            while (!parser.isClosed()) {
//
//                if (JsonToken.FIELD_NAME.equals(jsonToken) && parser.getCurrentName().toUpperCase().equals("TRANCODE")) {
//                    parser.nextToken();
//                    rabbitStatDTO.setTrancode(parser.getValueAsString());
//                }
//
//                if (JsonToken.FIELD_NAME.equals(jsonToken) && parser.getCurrentName().toUpperCase().equals("MESSAGE")) {
//                    parser.nextToken();
//                    rabbitStatDTO.setMessageCardStatus(parser.getValueAsString());
//                }
//
//                if (JsonToken.FIELD_NAME.equals(jsonToken) && parser.getCurrentName().toUpperCase().equals("PAN")) {
//                    parser.nextToken();
//                    rabbitStatDTO.setPan(parser.getValueAsString());
//                }
//                jsonToken = parser.nextToken();
//            }
//        } catch (IOException e) {
//            log.error("", e);
//        }
//
//        if (!LibUtil.isNullOrEmpty(rabbitStatDTO.getMessageCardStatus(), rabbitStatDTO.getPan(), rabbitStatDTO.getTrancode())){
//            return rabbitStatDTO;
//        }

}
