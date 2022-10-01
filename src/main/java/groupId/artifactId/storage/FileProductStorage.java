package groupId.artifactId.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import groupId.artifactId.storage.api.IProductStorage;
import groupId.artifactId.storage.entity.Product;

import java.io.*;
import java.util.*;

public class FileProductStorage implements IProductStorage {
    private final String filePath;
    private final ObjectMapper json = new ObjectMapper();

    public FileProductStorage() {
        String path = System.getenv("CATALINA_HOME");
        if (path == null || path.isBlank()) {
            throw new IllegalStateException("Environment variable CATALINA_HOME do not exist");
        }
        this.filePath = path + File.pathSeparator + "conf" + File.pathSeparator + "products.txt";
    }

    public FileProductStorage(String filePath) {
        File file = new File(filePath);
        if (!file.isDirectory()) {
            throw new IllegalStateException("filePath is not valid");
        } else if (!file.canWrite()) {
            throw new IllegalStateException("There is no write access in this filePath");
        }
        this.filePath = file.getAbsolutePath() + File.pathSeparator + "products.txt";
    }

    @Override
    public List<Product> get() {
        List<Product> temp = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                temp.add(json.readValue(line, Product.class));
            }
            return temp;
        } catch (IOException e) {
            throw new RuntimeException(e); // change
        }
    }

    @Override
    public Optional<Product> getById(int id) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Product product = json.readValue(line, Product.class);
                if (product.getId().equals(id)) {
                    return Optional.of(product);
                }
            }
            return Optional.empty();
        } catch (IOException e) {
            throw new RuntimeException(e); // change
        }
    }

    @Override
    public void save(Product product) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(json.writeValueAsString(product));
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
