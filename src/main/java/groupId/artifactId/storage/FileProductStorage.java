package groupId.artifactId.storage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import groupId.artifactId.exceptions.IncorrectBufferedOperation;
import groupId.artifactId.exceptions.IncorrectFilePathException;
import groupId.artifactId.exceptions.IncorrectJsonParseException;
import groupId.artifactId.storage.api.IProductStorage;
import groupId.artifactId.storage.entity.Product;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FileProductStorage implements IProductStorage {
    private final String filePath;
    private final ObjectMapper json = new ObjectMapper();
    private final AtomicInteger id = new AtomicInteger(1);

    public FileProductStorage() {
        String path = System.getenv("CATALINA_HOME");
        if (path == null || path.isBlank()) {
            throw new IllegalStateException("Environment variable CATALINA_HOME do not exist");
        }
        this.filePath = path + File.separator + "conf" + File.separator + "products.txt";
    }

    public FileProductStorage(String filePath) {
        File file = new File(filePath);
        if (!file.isDirectory()) {
            throw new IllegalStateException("filePath is not valid");
        } else if (!file.canWrite()) {
            throw new IllegalStateException("There is no write access in this filePath");
        }
        this.filePath = file.getAbsolutePath() + File.separator + "products.txt";
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
        } catch (FileNotFoundException e) {
            throw new IncorrectFilePathException("Incorrect file path: " + filePath, e);
        } catch (JsonProcessingException e) {
            throw new IncorrectJsonParseException("Impossible to parse, line into Product class", e);
        } catch (IOException e) {
            throw new IncorrectBufferedOperation("Impossible to read from a file: " + filePath, e);
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
        } catch (FileNotFoundException e) {
            throw new IncorrectFilePathException("Incorrect file path: " + filePath, e);
        } catch (JsonProcessingException e) {
            throw new IncorrectJsonParseException("Impossible to parse, line into Product class", e);
        } catch (IOException e) {
            throw new IncorrectBufferedOperation("Impossible to read from a file: " + filePath, e);
        }
    }

    @Override
    public void save(Product product) {
        product.setId(id.getAndIncrement());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(json.writeValueAsString(product));
            bufferedWriter.newLine();
        } catch (JsonProcessingException e) {
            throw new IncorrectJsonParseException("Impossible to parse, Product class into line " +
                    product, e);
        } catch (IOException e) {
            throw new IncorrectBufferedOperation("Impossible to write to a file: " + filePath, e);
        }
    }
}
