package groupId.artifactId.storage;

import groupId.artifactId.storage.entity.Product;
import groupId.artifactId.storage.entity.ProductBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FileProductStorageTest {
    @Test
    public void get(){

        FileProductStorage fileProductStorage = new FileProductStorage(System.getProperty("java.io.tmpdir"));
        Product product = ProductBuilder.create().setName("Car").setPrice(18000).setDiscount(2000).
                setDescription("New").build();
        List<Product> beforeTest = fileProductStorage.get();
        fileProductStorage.save(product);
        List<Product> test = fileProductStorage.get();
            Assertions.assertEquals(beforeTest.size()+1,test.size());
    }
    @Test
    public void testGetById() {
        FileProductStorage fileProductStorage = new FileProductStorage(System.getProperty("java.io.tmpdir"));
        Product product = ProductBuilder.create().setName("Car").setPrice(18000).setDiscount(2000).
                setDescription("New").build();
        fileProductStorage.save(product);
        fileProductStorage.getById(product.getId()).
                ifPresent(test -> Assertions.assertEquals(product.getId(), test.getId()));
    }
    @Test
    public void save(){
        FileProductStorage fileProductStorage = new FileProductStorage(System.getProperty("java.io.tmpdir"));
        Product product = ProductBuilder.create().setName("Car").setPrice(18000).setDiscount(2000).
                setDescription("New").build();
        fileProductStorage.save(product);
        Product test = fileProductStorage.getById(product.getId()).orElse(null);
        if (test!=null){
            Assertions.assertNotNull(test.getId());
            Assertions.assertEquals("Car",test.getName());
            Assertions.assertEquals(18000,test.getPrice());
            Assertions.assertEquals(2000,test.getDiscount());
            Assertions.assertEquals("New",test.getDescription());
        } else throw new RuntimeException();
    }
}
