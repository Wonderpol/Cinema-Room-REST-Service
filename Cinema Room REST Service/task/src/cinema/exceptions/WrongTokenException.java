package cinema.exceptions;

public class WrongTokenException extends Exception {
    public WrongTokenException() {
        super();
    }

    public WrongTokenException(final String message) {
        super(message);
    }

    public WrongTokenException(final Throwable cause) {
        super(cause);
    }
}
