package CustomExceptions;

public class RampIsNotDownException extends RuntimeException {
    public RampIsNotDownException(String errorMsg) {
        super(errorMsg);
    }
}
