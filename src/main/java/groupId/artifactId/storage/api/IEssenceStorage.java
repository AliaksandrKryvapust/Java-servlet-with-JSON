package groupId.artifactId.storage.api;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IEssenceStorage<TYPE> {
    List<TYPE> get() throws IOException, ClassNotFoundException;

    Optional<TYPE> getById(int id);

    void save(TYPE type) throws IOException;
}
