package groupId.artifactId.exceptions;

public class IncorrectFilePathException extends RuntimeException{
    public IncorrectFilePathException(String errorMsg, Throwable error){
        super(errorMsg, error);
    }
}
