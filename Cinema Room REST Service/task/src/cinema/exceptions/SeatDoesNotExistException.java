package cinema.exceptions;

public class SeatDoesNotExistException extends Exception {
    public SeatDoesNotExistException() {
        super();
    }

    public SeatDoesNotExistException(final String message) {
        super(message);
    }
}
