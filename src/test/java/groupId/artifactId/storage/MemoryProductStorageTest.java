package groupId.artifactId.storage;

import groupId.artifactId.storage.entity.Product;
import groupId.artifactId.storage.entity.ProductBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryProductStorageTest {

    @Test
    void get() {
        MemoryProductStorage memoryProductStorage = new MemoryProductStorage();
        Product product = ProductBuilder.create().setName("Car").setPrice(18000).setDiscount(2000).
                setDescription("New").build();
        List<Product> beforeTest = memoryProductStorage.get();
        int size = beforeTest.size();
        memoryProductStorage.save(product);
        List<Product> test = memoryProductStorage.get();
        Assertions.assertEquals(size+1,test.size());
    }

    @Test
    void getById() {
        MemoryProductStorage memoryProductStorage = new MemoryProductStorage();
        Product product = ProductBuilder.create().setName("Car").setPrice(18000).setDiscount(2000).
                setDescription("New").build();
        memoryProductStorage.save(product);
        memoryProductStorage.getById(product.getId()).
                ifPresent(test -> Assertions.assertEquals(product.getId(), test.getId()));
    }

    @Test
    void save() {
        MemoryProductStorage memoryProductStorage = new MemoryProductStorage();
        Product product = ProductBuilder.create().setName("Car").setPrice(18000).setDiscount(2000).
                setDescription("New").build();
        memoryProductStorage.save(product);
        Product test =memoryProductStorage.getById(product.getId()).orElse(null);
        if (test!=null){
            Assertions.assertNotNull(test.getId());
            Assertions.assertEquals("Car",test.getName());
            Assertions.assertEquals(18000,test.getPrice());
            Assertions.assertEquals(2000,test.getDiscount());
            Assertions.assertEquals("New",test.getDescription());
        } else throw new RuntimeException();
    }
}