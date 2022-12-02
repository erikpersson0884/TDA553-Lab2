package CustomExceptions;

public class RampIsNotInCorrectPositionException extends RuntimeException {
    public RampIsNotInCorrectPositionException(String errorMsg) {
        super(errorMsg);
    }
}
