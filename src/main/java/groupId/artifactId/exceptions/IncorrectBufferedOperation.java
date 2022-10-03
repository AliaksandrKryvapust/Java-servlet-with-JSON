package groupId.artifactId.exceptions;

public class IncorrectBufferedOperation extends RuntimeException {
    public IncorrectBufferedOperation(String errorMsg, Throwable error) {
        super(errorMsg, error);
    }
}
