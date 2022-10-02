package groupId.artifactId.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import groupId.artifactId.core.dto.ProductCreationDto;
import groupId.artifactId.storage.entity.Product;

import javax.servlet.ServletInputStream;
import java.io.IOException;
import java.util.List;

public class JsonConverter {

    public static String toJson(List<Product> product) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(product);
    }
    public static ProductCreationDto fromJson(ServletInputStream servletInputStream) throws IOException {
        return new ObjectMapper().readValue(servletInputStream,ProductCreationDto.class);
    }
}
