package CustomExceptions;

public class TransporterFullException extends RuntimeException {
    public TransporterFullException(String errorMsg) {
        super(errorMsg);
    }
}