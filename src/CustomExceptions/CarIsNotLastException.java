package CustomExceptions;

public class CarIsNotLastException extends RuntimeException {
    public CarIsNotLastException(String errorMsg) {
        super(errorMsg);
    }
}
