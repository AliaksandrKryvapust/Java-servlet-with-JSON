package groupId.artifactId.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import groupId.artifactId.storage.entity.Product;

import java.util.List;

public class JsonConverter {

    public static String toJson(List<Product> product) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(product);
    }
//    public static ProductCreationDto fromJson(String jsonString){
//        Gson gson = new Gson(jsonString);
//        return ProductCreationDtoBuilder.create().setName();
//    }
}
