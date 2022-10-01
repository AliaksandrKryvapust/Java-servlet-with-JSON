package groupId.artifactId.service.api;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IEEssenceService<TYPE> {
    List<TYPE> getById() throws IOException, ClassNotFoundException;
    Optional<TYPE> getById(int id);

}
