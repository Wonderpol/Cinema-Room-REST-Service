package cinema.exceptions;

public class InvalidPasswordException extends Exception {

    public InvalidPasswordException() {
    }

    public InvalidPasswordException(final String message) {
        super(message);
    }
}
