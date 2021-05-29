package exceptions;

public class DuplicatedKeyException extends RuntimeException {

    public DuplicatedKeyException(String message) {
        super(message);
    }

    public DuplicatedKeyException() {
        super("Duplicated key.");
    }
}
