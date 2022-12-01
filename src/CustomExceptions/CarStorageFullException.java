package CustomExceptions;

public class CarStorageFullException extends RuntimeException {
    public CarStorageFullException(String errorMsg) {
        super(errorMsg);
    }
}