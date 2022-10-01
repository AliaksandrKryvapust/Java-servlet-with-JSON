package groupId.artifactId.storage.api;

import groupId.artifactId.storage.FileProductStorage;
import groupId.artifactId.storage.MemoryProductStorage;

public class StorageFactory implements IStorageFactory {
    private static StorageFactory firstInstance = null;
    private final IProductStorage productStorage;
    public StorageFactory(){
        this.productStorage= new FileProductStorage();
    }

    public static StorageFactory getInstance() {
        synchronized (StorageFactory.class) {
            if (firstInstance == null) {
                firstInstance = new StorageFactory();
            }
        }
        return firstInstance;
    }
    @Override
    public IProductStorage getProductStorage() {
        return productStorage;
    }
}
