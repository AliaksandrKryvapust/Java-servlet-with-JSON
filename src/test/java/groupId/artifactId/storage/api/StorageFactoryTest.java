package groupId.artifactId.storage.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetEnvironmentVariable;

public class StorageFactoryTest {

    @Test
    @SetEnvironmentVariable(key = "CATALINA_HOME", value = "C://")
    public void testGetInstance() {
        IStorageFactory storageFactory = StorageFactory.getInstance();
        IStorageFactory storageFactory1 = StorageFactory.getInstance();
        Assertions.assertEquals(storageFactory,storageFactory1);
    }
}