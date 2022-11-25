package CustomExceptions;

public class CarIsAlreadyLoadedException extends RuntimeException {
    public CarIsAlreadyLoadedException(String errorMsg) {
        super(errorMsg);
    }
}