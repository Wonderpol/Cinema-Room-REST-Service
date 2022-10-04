package cinema.utils.exceptions;

public class SeatDoesNotExistException extends Exception {
    public SeatDoesNotExistException() {
        super();
    }

    public SeatDoesNotExistException(final Throwable cause) {
        super(cause);
    }
}
