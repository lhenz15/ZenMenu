package exceptions;

public class InstanceNotFoundException extends RuntimeException {

    public InstanceNotFoundException(String message) {
        super(message);
    }

    public InstanceNotFoundException() {
        super("Instance not found.");
    }
}
