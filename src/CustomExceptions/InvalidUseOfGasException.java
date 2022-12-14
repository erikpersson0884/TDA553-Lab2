package CustomExceptions;

public class InvalidUseOfGasException extends RuntimeException {
    public InvalidUseOfGasException(String errorMsg) {
        super(errorMsg);
    }
}
