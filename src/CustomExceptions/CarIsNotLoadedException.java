package CustomExceptions;

public class CarIsNotLoadedException extends RuntimeException {
    public CarIsNotLoadedException(String errorMsg) {
        super(errorMsg);
    }
}