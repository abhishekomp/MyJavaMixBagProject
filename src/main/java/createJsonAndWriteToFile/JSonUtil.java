package createJsonAndWriteToFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

/**
 * Created by sca820 on 02 aug., 2022
 * Referenced video playlist: https://www.youtube.com/watch?v=vi1lU57U2p8&list=PLAuGQNR28pW4dOc5uytMdzcQ4-TCJFUN4&index=4
 */
public class JSonUtil {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;
    }

    public static JsonNode parse (String jsonStr) {
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(jsonStr);      //readTree method is used to read from the String and returns an object of JsonNode
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }

    public static <A> A fromJSon(JsonNode node, Class<A> clazz) throws JsonProcessingException {
        return objectMapper.treeToValue(node, clazz);       //treeToValue takes an object of type JsonNode and clazz and returns an instance of clazz
    }

    public static JsonNode toJson(Object obj) {
        final JsonNode jsonNode = objectMapper.valueToTree(obj);    //valueToTree is used to read an instance of particular class and returns an object of JsonNode
        return jsonNode;
    }

    public static String stringify(JsonNode node) throws JsonProcessingException {
//        ObjectWriter writer = objectMapper.writer();
//        return writer.writeValueAsString(node);
        return generateString(node, false);
    }

    public static String prettyPrint(JsonNode node) throws JsonProcessingException {
//        ObjectWriter objectWriter = objectMapper.writer();
//        objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
//        return objectWriter.writeValueAsString(node);
        return generateString(node, true);
    }

    private static String generateString(JsonNode node, boolean isPretty) throws JsonProcessingException {
        ObjectWriter objectWriter = objectMapper.writer();
        if(isPretty) {
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        }
        return objectWriter.writeValueAsString(node);
    }

}
