package groupId.artifactId.utils;

import com.google.gson.Gson;
import groupId.artifactId.storage.entity.Product;

import java.util.List;

public class JsonConverter {
    public static String toJson(List<Product> product) {
        return new Gson().toJson(product);
    }
}
